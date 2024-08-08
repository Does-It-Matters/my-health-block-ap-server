package com.example.myhealthblock.jwt;
import com.example.myhealthblock.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.access-token.expiration}")
    private Long accessTokenExpiration;

    @Value("${jwt.refresh-token.expiration}")
    private Long refreshTokenExpiration;

    public Map<String, String> generateTokens(User user) {
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", generateAccessToken(user));
        tokens.put("refreshToken", generateRefreshToken(user));
        return tokens;
    }

    private String generateAccessToken(User user) {
        return generateToken(user, accessTokenExpiration);
    }

    private String generateRefreshToken(User user) {
        return generateToken(user, refreshTokenExpiration);
    }

    private String generateToken(User user, long expiration) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(user.getUid())//token의 주체를 uid로 설정
                .claim("role", user.getRole())//토큰에 role 추가
                .setIssuedAt(now)//토큰 발행 시간을 현재 시간으로 설정
                .setExpiration(expiryDate)//토큰 만료 시간 설정
                .signWith(key)//토큰 서명
                .compact();//JWT문자열 생성
    }

}