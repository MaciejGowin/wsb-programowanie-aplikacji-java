package com.coderbrother.javaprogramming.security.service;

import com.coderbrother.javaprogramming.security.model.BasicPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSignature;
    @Value("${jwt.expirationInMinutes}")
    private long jwtExpirationInMinutes;

    public Optional<String> generateToken(final BasicPrincipal basicUser) {
        try {
            return Optional.of(Jwts.builder()
                    .subject(basicUser.getName())
                    .claims(Map.of())
                    .expiration(Date.from(Instant.now().plusSeconds(jwtExpirationInMinutes * 60)))
                    .signWith(getSigningKey())
                    .compact());
        } catch (Exception ex) {
            log.warn("Failed to generate token: {}", ex.getMessage(), ex);
            return Optional.empty();
        }
    }

    public Optional<BasicPrincipal> decryptToken(final String token) {
        try {
            Claims body = Jwts.parser().verifyWith(getSigningKey()).build()
                    .parseSignedClaims(token)
                    .getPayload();
            return Optional.of(BasicPrincipal.builder()
                    .userId(body.getSubject())
                    .build());
        } catch (Exception ex) {
            log.warn("Failed to decrypt token: {}", ex.getMessage(), ex);
            return Optional.empty();
        }
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = jwtSignature.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
