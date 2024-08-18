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

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

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

    private boolean hasBearer(String authHeader) {
        return authHeader != null && authHeader.startsWith("Bearer ");
    }

    private void processJwtAuthentication(String authHeader, HttpServletRequest request) {
        final String JWT = authHeader.substring(7);
        final String USER_ID = jwtService.extractUid(JWT);

        authenticateUserIfTokenValid(USER_ID, JWT, request);
    }

    private void authenticateUserIfTokenValid(String userUid, String jwt, HttpServletRequest request) {
        if (shouldAuthenticate(userUid, jwt)) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userUid);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            setAuthenticationContext(authToken, request);
        }
    }

    private boolean shouldAuthenticate(String userUid, String jwt) {
        return userUid != null &&
                SecurityContextHolder.getContext().getAuthentication() == null &&
                jwtService.isTokenValid(jwt);
    }

    private void setAuthenticationContext(UsernamePasswordAuthenticationToken authToken, HttpServletRequest request) {
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}