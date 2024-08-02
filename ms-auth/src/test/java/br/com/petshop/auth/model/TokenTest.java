package br.com.petshop.auth.model;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    @Test
    void shouldCreateUUID() {
        var user = new User();
        user.setEnrollment(2);

        var jwt = "alksjdflasdfasj23ç4123jq23rjlf";

        var token = new Token(user, jwt);
        String refresh = token.getRefresh();

        assertNotNull(refresh);
        assertTrue(StringUtils.isNotBlank(refresh));
    }

    @Test
    void shouldValidAsValid() {
        var token = new Token();
        token.setCreatedAt(LocalDateTime.now());

        assertTrue(token.isValid());
    }

    @ParameterizedTest
    @MethodSource("sourceValidAsNotValid")
    void shouldValidAsNotValid(LocalDateTime date) {
        var token = new Token();
        token.setCreatedAt(date);

        assertFalse(token.isValid());
    }

    static Stream<Arguments> sourceValidAsNotValid() {
        var last = LocalDateTime.now().minusDays(1);
        var tomorrow = LocalDateTime.now().plusDays(1);

        return Stream.of(
            Arguments.of(last),
            Arguments.of( tomorrow),
            Arguments.of(tomorrow)
        );
    }

    @Test
    void shouldCheckIfUserIsEqualToUserToken() {
        int enrollment = 2;

        var user = new User();
        user.setEnrollment(enrollment);

        var token = new Token();
        token.setUser(user);

        assertTrue(token.checkEnrollment(enrollment));
    }

    @ParameterizedTest
    @MethodSource("sourceCheckNotEqualUser")
    void shouldCheckNotEqualUser(Integer enrollment) {
        var user = new User();
        user.setEnrollment(2);

        var token = new Token();
        token.setUser(user);

        assertFalse(token.checkEnrollment(enrollment));
    }

    static Stream<Arguments> sourceCheckNotEqualUser() {
        Integer nullable = null;
        return Stream.of(
            Arguments.of(nullable),
            Arguments.of(0),
            Arguments.of(3)
            );
    }
}