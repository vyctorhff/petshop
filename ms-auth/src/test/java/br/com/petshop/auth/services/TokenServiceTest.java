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
        User user = new User();
        user.setName("name");
        user.setAlias("alias");
        user.setEnrollment(2);
        user.setPass("1234");
        return user;
    }
}