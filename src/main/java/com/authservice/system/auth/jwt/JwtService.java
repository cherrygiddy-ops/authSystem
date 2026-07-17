package com.authservice.system.auth.jwt;

import com.authservice.system.users.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class JwtService {
 private final JwtConfig config;

    public Jwt generateAccessTokens(User entity){
     return generateToken(entity, config.getAccessExpiration());
    }

    public Jwt generateRefreshTokens(User entity){
        return generateToken(entity, config.getRefreshExpiration());
    }

    private Jwt generateToken(User entity, int expirationSeconds) {
        String token = Jwts.builder()
                .subject(entity.getId().toString())
                .claim("name", entity.getUsername())
                .claim("email", entity.getEmail())
                .claim("role", entity.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L * expirationSeconds))
                .signWith(config.getSecretKey())
                .compact();

        Claims claims = Jwts.parser()
                .verifyWith(config.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return new Jwt(token, claims);
    }

    public Jwt parseToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            System.out.println("Token is missing or blank");
            return null;
        }

        try {
            Claims claims = getClaims(token);
            System.out.println("Token subject: " + claims.getSubject());
            return new Jwt(token, claims); // ✅ pass the raw token string + claims
        } catch (JwtException ex) {
            System.out.println("Invalid token: " + ex.getMessage());
            return null;
        }
    }

    private Claims getClaims(String token) {
        if (token == null || token.trim().isEmpty()) {
            throw new IllegalArgumentException("Token is missing or blank");
        }

        try {
            return Jwts.parser()
                    .verifyWith(config.getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            System.out.println("JWT parsing failed: " + e.getMessage());
            throw e;
        }
    }

}
