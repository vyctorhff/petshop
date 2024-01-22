package br.com.petshop.auth.service;

import br.com.petshop.auth.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService {

    @Value("${security.jwt.secret}")
    private String jwtSecret;

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(jwtSecret);
    }

    private String getIssuer() {
        return "auth-api";
    }

    private Instant getExpire() {
        return LocalDateTime.now()
            .plusHours(2)
            .toInstant(ZoneOffset.of("-03:00"));
    }

    public String generate(User user) {
        try {
            return JWT.create()
                .withIssuer(getIssuer())
                .withSubject(user.getEnrollment())
                .withExpiresAt(getExpire())
                .sign(getAlgorithm());
        } catch (JWTCreationException e) {
            throw new IllegalStateException("fail at jwt creation");
        }
    }

    public String validate(String token) {
        try {
            return JWT.require(getAlgorithm())
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException e) {
            return StringUtils.EMPTY;
        }
    }

    public String refresh() {
        throw new NotImplementedException();
    }
}
