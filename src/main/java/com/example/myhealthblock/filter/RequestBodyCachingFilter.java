package com.example.myhealthblock.filter;

import jakarta.servlet.*;
        import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;

// 목적: Request Body를 여러번 읽을 수 있도록 캐싱
// 상황: 사용자 요청에 대한 로그를 남기기 위해 request body를 읽는 상황
//      캐싱을 하지 않으면 한번만 읽을 수 있어 로그를 적용할 수 없음
@Component
public class RequestBodyCachingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        chain.doFilter(wrappedRequest, response);
    }
}