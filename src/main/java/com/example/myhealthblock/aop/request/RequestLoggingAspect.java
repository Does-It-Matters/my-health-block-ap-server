package com.example.myhealthblock.aop.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// 목적: 사용자 요청을 분석하기 위해 로그 기록
// 활용: "Request: URL=%s, Method=%s, Headers={%s}, Parameters={%s}, Body=%s"를 request.log와 콘솔에 출력
// 유의 사항: 성능(메모리, 응답 시간 등)과 보안을 고려한다면 request body 읽는 것에 유의
@Aspect
@Component
public class RequestLoggingAspect {

    private static final Logger logger = LogManager.getLogger("request-logger"); // log4j2.xml에 설정된 logger 가져오기
    private static final ObjectMapper objectMapper = new ObjectMapper(); // json 바디를 다루기 위해 사용

    @Around("execution(* com.example.myhealthblock.*.adapter.in.*Controller.*(..))") // 사용자 요청을 위한 controller 클래스들에 적용
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        if (request instanceof ContentCachingRequestWrapper) { // request body는 한번만 읽을 수 있어 캐싱을 적용해는지 확인
            ContentCachingRequestWrapper wrappedRequest = (ContentCachingRequestWrapper) request; // 캐싱 객체를 활용하여 바디 값 읽을 수 있음

            String requestInfo = getRequestInfo(wrappedRequest); // 요청에 대한 데이터를 문자열로 만들기
            logger.info(requestInfo); // 로그 남기기

            Object result = joinPoint.proceed();

            logger.info("Method executed successfully.");

            return result;
        } else {
            // ContentCachingRequestWrapper가 적용되지 않은 경우
            logger.warn("Request is not wrapped with ContentCachingRequestWrapper");
            return joinPoint.proceed();
        }
    }

    private String getRequestInfo(ContentCachingRequestWrapper request) throws IOException {
        return String.format("Request: URL=%s, Method=%s, Headers={%s}, Parameters={%s}, Body=%s",
                request.getRequestURL(), request.getMethod(), getHeadersInfo(request), getRequestParameters(request), getRequestBodyOneLine(request));
    }

    private String getHeadersInfo(HttpServletRequest request) {
        StringBuilder headers = new StringBuilder();
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> headers.append(headerName).append(": ").append(request.getHeader(headerName)).append(", "));
        return headers.toString();
    }

    private String getRequestParameters(HttpServletRequest request) {
        StringBuilder params = new StringBuilder();
        request.getParameterMap().forEach((key, value) -> params.append(key).append("=").append(String.join(",", value)).append(", "));
        return params.toString();
    }

    private String getRequestBody(ContentCachingRequestWrapper request) {
        byte[] content = request.getContentAsByteArray();
        if (content.length > 0) {
            return new String(content, StandardCharsets.UTF_8);
        }
        return "";
    }

    // getRequestBody 예쁘게 출력
    private String getRequestBodyOneLine(ContentCachingRequestWrapper request) {
        byte[] content = request.getContentAsByteArray();
        if (content.length > 0) {
            String body = new String(content, StandardCharsets.UTF_8);
            // JSON 형식인 경우 한 줄로 압축
            if (request.getContentType() != null && request.getContentType().contains("application/json")) {
                try {
                    return objectMapper.writeValueAsString(objectMapper.readTree(body));
                } catch (JsonProcessingException e) {
                    logger.warn("Failed to parse JSON body", e);
                }
            }
            // JSON이 아니거나 파싱에 실패한 경우 그대로 반환
            return body.replaceAll("\\s+", " "); // 여러 줄의 공백을 하나의 공백으로 대체
        }
        return "";
    }
}