//package com.example.myhealthblock.config;
//
//import com.example.myhealthblock.filter.JwtAuthenticationFilter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * <b> 역할: 보안 설정하는 클래스 </b>
// * <br>- JwtAuthenticationFilter 필터 적용
// * <br>- 세션 관리를 Stateless로 설정
// * <br>- 특정 엔드포인트에 대한 접근 권한 설정
// *
// * @see JwtAuthenticationFilter
// */
//@Slf4j
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtAuthenticationFilter jwtAuthFilter;
//
//    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter) {
//        this.jwtAuthFilter = jwtAuthFilter;
//    }
//
//    /**
//     * <b> 역할: 보안 필터 체인을 구성하는 메소드 </b>
//     * <br>- CSRF 비활성화
//     * <br>- Stateless 세션 관리 설정
//     * <br>- JWT 인증 필터 추가
//     *
//     * @param http HttpSecurity 객체
//     * @return SecurityFilterChain 객체
//     * @throws Exception 설정 중 오류 발생 시
//     */
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll()  // 개발용. 모든 요청 허용
//                )
//                //Jwt 검증 적용 버전
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/v*/sign-in").permitAll()
////                        .requestMatchers("/api/v2/patient/sign-up").permitAll()
////                        .requestMatchers("/api/v2/doctor/sign-up").permitAll()
////                        .requestMatchers("/api/v2/question/list").permitAll()
////                        .anyRequest().authenticated()
////                )
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .httpBasic(httpBasic -> httpBasic.disable())
//                .formLogin(formLogin -> formLogin.disable());
//
//        return http.build();
//    }
//}