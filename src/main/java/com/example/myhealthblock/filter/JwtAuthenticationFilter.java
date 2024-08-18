package com.example.myhealthblock.filter;

import com.example.myhealthblock.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

/**
 * <b> 역할: JWT 인증을 처리하는 필터 클래스 </b>
 * <br>- 매 요청마다 한 번씩 실행
 * <br>- JWT 토큰의 유효성 검증
 * <br>- 사용자 인증
 */
@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    /**
     * <b> 역할: 토큰을 추출하여 사용자 인증하는 메소드 </b>
     * <br>- 요청이 필터 체인을 통과할 때 호출
     * <br>- Authorization 헤더에서 JWT 토큰 추출
     * <br>- 토큰이 유효한 경우 사용자 인증 수행
     *
     * @param request  현재 HTTP 요청
     * @param response 현재 HTTP 요청
     * @param filterChain 필터 체인
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException      입출력 예외 발생 시
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if ( ! hasBearer(authHeader) ) {
            filterChain.doFilter(request, response);
            return;
        }

        processJwtAuthentication(authHeader, request);
        filterChain.doFilter(request, response);
    }

    /**
     * <b> 역할: Authorization 헤더가 "Bearer "로 시작하는지 확인하는 메소드 </b>
     * 
     * @param authHeader Authorization 헤더 값
     * @return 헤더가 "Bearer "로 시작하면 true, 그렇지 않으면 false
     */
    private boolean hasBearer(String authHeader) {
        return authHeader != null && authHeader.startsWith("Bearer ");
    }

    /**
     * <b> 역할: JWT 토큰을 추출 후 사용자 UID로 인증 처리하는 메소드 </b>
     *
     * @param authHeader Authorization 헤더 값
     * @param request    현재 HTTP 요청
     */
    private void processJwtAuthentication(String authHeader, HttpServletRequest request) {
        final String JWT = authHeader.substring(7);
        final String USER_ID = jwtService.extractUid(JWT);

        authenticateUserIfTokenValid(USER_ID, JWT, request);
    }

    /**
     * <b> 역할: JWT가 유효한 경우 사용자 인증을 처리하는 메소드 </b>
     *
     * @param userUid 사용자 UID
     * @param jwt     JWT 토큰
     * @param request 현재 HTTP 요청
     */
    private void authenticateUserIfTokenValid(String userUid, String jwt, HttpServletRequest request) {
        if (shouldAuthenticate(userUid, jwt)) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userUid);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            setAuthenticationContext(authToken, request);
        }
    }

    /**
     * <b> 역할: 사용자 UID와 JWT 토큰이 유효하고, 현재 인증 컨텍스트가 비어있는지 확인하는 메소드 </b>
     *
     * @param userUid 사용자 UID
     * @param jwt     JWT 토큰
     * @return jwt 인증 처리가 가능한 상황이면 true, 그렇지 않으면 false
     */
    private boolean shouldAuthenticate(String userUid, String jwt) {
        return userUid != null &&
                SecurityContextHolder.getContext().getAuthentication() == null &&
                jwtService.isTokenValid(jwt);
    }

    /**
     * <b> 역할: 인증된 사용자 정보를 SecurityContext에 설정하는 메소드 </b>
     *
     * @param authToken 인증된 사용자 토큰
     * @param request   JWT 토큰
     */
    private void setAuthenticationContext(UsernamePasswordAuthenticationToken authToken, HttpServletRequest request) {
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}