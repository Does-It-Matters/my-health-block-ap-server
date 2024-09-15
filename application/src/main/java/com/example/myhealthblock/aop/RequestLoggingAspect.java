//package com.example.myhealthblock.aop;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//import java.nio.charset.StandardCharsets;
//
///**
// * <b> 역할: 요청 내용과 실행 시간 로깅 Aspect 클래스 </b>
// * <br>- 사용자 요청을 분석하기 위해 로그 기록
// * <br>- 특정 포맷으로 request.log파일과 콘솔에 출력
// * <br>- 유의 사항: 성능(메모리, 응답 시간 등)과 보안을 고려 시,
// * <br>-          request body 읽는 것에 유의
// * <br>- 실행 시간 로그와 요청 로그를 분석하는 코드로 분리 계획
// */
//@Aspect
//@Component
//public class RequestLoggingAspect {
//
//    private static final Logger logger = LogManager.getLogger("request-logger");
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//    private static final String JSON_CONTENT_TYPE = "application/json";
//    private static final String REQUEST_LOG_FORMAT = "id: {}, {}, {}";
//
//    // 사용자 요청을 위한 controller 클래스들에 적용
//    /**
//     * <b> 역할: 요청을 가로채서 요청시간과 내용을 로깅하는 메소드 </b>
//     * <br>- 사용자 요청을 분석하기 위해 로그 기록
//     * <br>- 특정 포맷으로 request.log파일과 콘솔에 출력
//     * <br>- 유의 사항: 성능(메모리, 응답 시간 등)과 보안을 고려 시,
//     * <br>-          request body 읽는 것에 유의
//     */
//    @Around("execution(* com.example.myhealthblock.*.adapter.in.*Controller.*(..))")
//    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//
//        if (isContentCachingRequestWrapper(request)) {
//            String requestInfo = getRequestInfo((ContentCachingRequestWrapper) request);
//
//            long startTime = System.currentTimeMillis();
//            Object result = joinPoint.proceed();
//            long endTime = System.currentTimeMillis();
//
//            String executionTime = String.format(formatExecutionTime(endTime - startTime));
//            long gatewayRequestId = 0; // 현재는 dummy data
//
//            logger.info(REQUEST_LOG_FORMAT, gatewayRequestId, executionTime, requestInfo);
//            return result;
//        } else {
//            logger.warn("Request is not wrapped with ContentCachingRequestWrapper");
//            return joinPoint.proceed();
//        }
//    }
//
//    /**
//     * <b> 역할: request body는 한번만 읽을 수 있어 캐싱을 적용해는지 확인하는 메소드 </b>
//     *
//     * @param request 필터로 캐싱되었을 수 있는 현재 HTTP 요청
//     * @return 캐싱되었으면 true, 캐싱되지 않았으면 false
//     */
//    private boolean isContentCachingRequestWrapper(HttpServletRequest request) {
//        return request instanceof ContentCachingRequestWrapper;
//    }
//
//    /**
//     * <b> 역할: 실행 시간에 대한 포맷을 만드는 메소드 </b>
//     *
//     * @param durationMillis 측정하고자 하는 실행 시간
//     * @return 특정 포맷의 문자열 반환
//     */
//    private String formatExecutionTime(long durationMillis) {
//        return String.format("%6s", durationMillis + "ms");
//    }
//
//    /**
//     * <b> 역할: 요청에 대한 정보를 특정 포맷의 문자열을 만드는 메소드 </b>
//     *
//     * @param request 캐싱되어있는 현재 HTTP 요청
//     * @return HTTP에 대한 데이터들을 특정 문자열 포맷으로 반환
//     */
//    private String getRequestInfo(ContentCachingRequestWrapper request) {
//        return String.format("Request: URL=%s, Method=%s, Headers={%s}, Parameters={%s}, Body=%s",
//                request.getRequestURL(),
//                request.getMethod(),
//                getHeadersInfo(request),
//                getRequestParameters(request),
//                getRequestBodyOneLine(request));
//    }
//
//    /**
//     * <b> 역할: HTTP 요청에서 헤더 정보를 특정 문자열 포맷으로 만드는 메소드 </b>
//     *
//     * @param request 현재 HTTP 요청
//     * @return HTTP 헤더 정보에 대한 특정 포맷의 문자열 반환
//     */
//    private String getHeadersInfo(HttpServletRequest request) {
//        StringBuilder headers = new StringBuilder();
//        request
//                .getHeaderNames()
//                .asIterator()
//                .forEachRemaining(
//                        headerName -> headers
//                                .append(headerName)
//                                .append(": ")
//                                .append(request
//                                        .getHeader(headerName))
//                                .append(", "));
//
//        return headers.toString();
//    }
//
//    /**
//     * <b> 역할: HTTP 요청에서 파라미터 정보를 특정 문자열 포맷으로 만드는 메소드 </b>
//     *
//     * @param request 현재 HTTP 요청
//     * @return HTTP 파라미터 정보에 대한 특정 포맷의 문자열 반환
//     */
//    private String getRequestParameters(HttpServletRequest request) {
//        StringBuilder params = new StringBuilder();
//        request
//                .getParameterMap()
//                .forEach((key, value) -> params
//                        .append(key)
//                        .append("=")
//                        .append(String
//                                .join(",", value))
//                        .append(", "));
//
//        return params.toString();
//    }
//
//
//    /**
//     * <b> 역할: HTTP 요청에서 바디 정보를 특정 문자열 포맷으로 만드는 메소드 </b>
//     *
//     * @param request 캐싱되어있는 현재 HTTP 요청
//     * @return HTTP 요청 바디 정보에 대한 특정 포맷의 문자열 반환
//     */
//    private String getRequestBody(ContentCachingRequestWrapper request) {
//        byte[] content = request.getContentAsByteArray();
//        if (content.length > 0) {
//            return new String(content, StandardCharsets.UTF_8);
//        }
//        return "";
//    }
//
//    /**
//     * <b> 역할: getRequestBody 정보를 한 줄로 예쁘게 출력하는 메소드 </b>
//     *
//     * @param request 캐싱되어있는 현재 HTTP 요청
//     * @return HTTP 요청 바디 정보에 대한 특정 포맷의 문자열 반환
//     */
//    private String getRequestBodyOneLine(ContentCachingRequestWrapper request) {
//        byte[] content = request.getContentAsByteArray();
//        if (content.length > 0) {
//            String body = new String(content, StandardCharsets.UTF_8);
//            // JSON 형식인 경우 한 줄로 압축
//            if (isJsonContent(request)) {
//                try {
//                    return objectMapper.writeValueAsString(objectMapper.readTree(body));
//                } catch (JsonProcessingException e) {
//                    logger.warn("Failed to parse JSON body", e);
//                }
//            }
//            // JSON이 아니거나 파싱에 실패한 경우 그대로 반환
//            return body.replaceAll("\\s+", " "); // 여러 줄의 공백을 하나의 공백으로 대체
//        }
//        return "";
//    }
//
//    /**
//     * <b> 역할: json 내용인지 판단하는 메소드 </b>
//     *
//     * @param request 캐싱되어있는 현재 HTTP 요청
//     * @return json 내용이면 true, 아니면 false
//     */
//    private boolean isJsonContent(ContentCachingRequestWrapper request) {
//        return request.getContentType() != null && request.getContentType().contains(JSON_CONTENT_TYPE);
//    }
//}