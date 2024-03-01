package br.com.petshop.auth.infra.security;

import br.com.petshop.auth.services.TokenService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class TokenFilterTest {

    @InjectMocks
    private TokenFilter sut;

    @Mock
    private TokenService tokenService;

    @Mock
    private AuthenticatioService authenticatioService;

    @Test
    void shouldAuthenticate() {
        fail("do test");
    }
}