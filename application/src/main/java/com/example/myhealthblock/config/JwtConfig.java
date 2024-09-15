//package com.example.myhealthblock.config;
//
//import com.example.myhealthblock.jwt.JwtService;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
///**
// * <b> 역할: JWT 관련 설정을 제공하는 클래스 </b>
// * <br>- JWT 비밀 키와 토큰 만료 시간을 프로퍼티 파일에서 로드
// * <br>- JwtService 빈 등록
// */
//@Configuration
//@PropertySource("classpath:application-jwt.properties")
//public class JwtConfig {
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.access-token.expiration}")
//    private Long accessTokenExpiration;
//
//    @Value("${jwt.refresh-token.expiration}")
//    private Long refreshTokenExpiration;
//
//    /**
//     * <b> 역할: JwtService 빈을 컨텍스트에 등록하는 메소드 </b>
//     * <br>- JWT 토큰 생성 및 검증 처리하는 빈 등록
//     *
//     * @return JwtService 객체
//     */
//    @Bean
//    public JwtService jwtService() {
//        return new JwtService();
//    }
//
//}
