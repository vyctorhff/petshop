package br.com.petshop.auth.services;

import br.com.petshop.auth.infra.TokenRepositoy;
import br.com.petshop.auth.model.Token;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.controllers.dto.TokenRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class TokenServiceTest {

    public static final String TOKEN = "çsajfçoawuer";
    public static final String TOKEN_REFRESH = "alskd-1k2j3";

    @InjectMocks
    private TokenService sut;

    @Mock
    private TokenRepositoy tokenRepositoy;

    @Captor
    private ArgumentCaptor<Token> captorToken;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(sut, "jwtSecret", "jwt-key-secret");
    }

    @Test
    void shouldGenerate() {
        User user = getUser();
        String token = sut.generate(user);

        assertNotNull(token);
        assertFalse(StringUtils.isBlank(token));
    }

    @Test
    void shouldValidate() {
        User user = getUser();
        String token = sut.generate(user);

        String validate = sut.validate(token);

        assertFalse(StringUtils.isBlank(validate));
        assertEquals("2", validate);
    }

    @Test
    void shouldCreateRefresh() {
        sut.createRefresh(getUser(), TOKEN);
        verify(tokenRepositoy, Mockito.only()).save(any());
    }

    @Test
    void shouldRefreshToken() {
        var user = getUser();
        var dto = new TokenRequestDTO(user.getEnrollment(), TOKEN_REFRESH);

        var tokenResult = new Token(user, TOKEN);
        tokenResult.setRefresh(TOKEN_REFRESH);

        when(tokenRepositoy.findByRefresh(dto.refresh()))
            .thenReturn(tokenResult);

        sut.refresh(dto);

        assertEquals(TOKEN_REFRESH, tokenResult.getRefresh());

        verify(tokenRepositoy).save(captorToken.capture());
        Token tokenUpdated = captorToken.getValue();

        assertNotEquals(tokenUpdated.getToken(), TOKEN_REFRESH);
    }

    @Test
    void shouldRefreshTokenWithInvalidRefreshToken() {
        var user = getUser();
        var dto = new TokenRequestDTO(user.getEnrollment(), TOKEN_REFRESH);

        when(tokenRepositoy.findByRefresh(dto.refresh()))
            .thenReturn(null);

        assertThrows(IllegalStateException.class, () -> sut.refresh(dto));
    }

    @ParameterizedTest
    @MethodSource("sourceInvalidCheck")
    void shouldRefreshTokenWithInvalidCheck(Token token, Integer enrollment) {
        var dto = new TokenRequestDTO(enrollment, TOKEN_REFRESH);

        when(tokenRepositoy.findByRefresh(dto.refresh()))
            .thenReturn(token);

        assertThrows(IllegalStateException.class, () -> sut.refresh(dto));
    }

    private static Stream<Arguments> sourceInvalidCheck() {
        var user = getUser();
        var token = getToken();
        var wrongEnrollment = Arguments.of(token, -2);

        token = getToken();
        token.setCreatedAt(LocalDateTime.now().minusDays(1));
        var wrongDate = Arguments.of(token, user.getEnrollment());

        return Stream.of(
            wrongEnrollment,
            wrongDate
        );
    }

    private static User getUser() {
        return User.builder()
            .name("name")
            .alias("alias")
            .enrollment(2)
            .pass("1234")
            .build();
    }

    private static Token getToken() {
        var user = getUser();
        var token = new Token(user, TOKEN);
        token.setRefresh(TOKEN_REFRESH);

        return token;
    }
}