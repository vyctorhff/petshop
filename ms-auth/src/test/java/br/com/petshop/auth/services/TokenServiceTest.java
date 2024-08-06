package br.com.petshop.auth.services;

import br.com.petshop.auth.infra.TokenRepositoy;
import br.com.petshop.auth.model.Token;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.model.dto.TokenRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;

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

    private static User getUser() {
        return User.builder()
            .name("name")
            .alias("alias")
            .enrollment(2)
            .pass("1234")
            .build();
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

        assertNotEquals(tokenResult, tokenResult.getToken());
        assertEquals(TOKEN_REFRESH, tokenResult.getRefresh());
    }

    @Test
    void shouldRefreshTokenWithInvalidRefreshToken() {
        var user = getUser();
        var dto = new TokenRequestDTO(user.getEnrollment(), TOKEN_REFRESH);

        when(tokenRepositoy.findByRefresh(dto.refresh()))
            .thenReturn(null);

        assertThrows(IllegalStateException.class, () -> sut.refresh(dto));
    }

    @Test
    void shouldRefreshTokenWithInvalidEnrollment() {
        var user = getUser();
        var dto = new TokenRequestDTO(-2, TOKEN_REFRESH);

        var tokenResult = new Token(user, TOKEN);
        tokenResult.setRefresh(TOKEN_REFRESH);

        when(tokenRepositoy.findByRefresh(dto.refresh()))
            .thenReturn(tokenResult);

        assertThrows(IllegalStateException.class, () -> sut.refresh(dto));
    }

    @Test
    void shouldRefreshTokenInvalidBecauseOneDay() {
        var user = getUser();
        var dto = new TokenRequestDTO(-2, TOKEN_REFRESH);

        var tokenResult = new Token(user, TOKEN);
        tokenResult.setRefresh(TOKEN_REFRESH);
        tokenResult.setCreatedAt(LocalDateTime.now().minusDays(1));

        when(tokenRepositoy.findByRefresh(dto.refresh()))
            .thenReturn(tokenResult);

        assertThrows(IllegalStateException.class, () -> sut.refresh(dto));
    }
}