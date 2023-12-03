package com.br.srv.saudeconnect.auth.core.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.br.srv.saudeconnect.enums.ExceptionEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
public class AuthTokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${spring.application.name}")
    private String issuer;

    public String generateToken(final UserDetails user) {
        try {
            final Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(issuer)
                    .withIssuedAt(creationDate())
                    .withExpiresAt(expirationDate())
                    .withSubject(user.getUsername())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new JWTCreationException(ExceptionEnum.AUTHENTICATION_ERROR_GENERATE_TOKEN.getMessage(), exception);
        }
    }

    public String getSubjectFromToken(final String token) {
        try {
            final Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException(ExceptionEnum.AUTHENTICATION_INVALID_TOKEN.getMessage(), exception);
        }
    }

    private Instant creationDate() {
        return ZonedDateTime.now(ZoneId.systemDefault()).toInstant();
    }

    private Instant expirationDate() {
        return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))
                .plusHours(expiration)
                .toInstant();
    }
}
