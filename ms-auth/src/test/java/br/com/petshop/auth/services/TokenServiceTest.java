package br.com.petshop.auth.services;

import br.com.petshop.auth.model.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith({MockitoExtension.class})
class TokenServiceTest {

    @InjectMocks
    private TokenService sut;

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
        fail();
    }

    @Test
    void shouldRefreshToken() {
        fail();
    }
}