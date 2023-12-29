package br.com.petshop.auth.config;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SecurityConfigTest {

    public static final String PASSWORD_SIMPLE = "123456";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldEncodeSuccessfully() {
        String result = passwordEncoder.encode(PASSWORD_SIMPLE);

        assertNotNull(result);
        assertFalse(StringUtils.isBlank(result));
    }

    @Test
    void shouldCheck() {
        String encoded = passwordEncoder.encode(PASSWORD_SIMPLE);
        var checked = passwordEncoder.matches(PASSWORD_SIMPLE, encoded);

        assertTrue(checked);
    }
}