package br.com.petshop.auth.infra.security;

import br.com.petshop.auth.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class TokenFilterTest {

    @InjectMocks
    private TokenFilter sut;

    @Mock
    private TokenService tokenService;

    @Mock
    private AuthenticatioService authenticatioService;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private FilterChain filterChain;

    @Test
    void shouldAuthenticate() throws ServletException, IOException {
        var token = "aabbcc";
        var requestToken = "Bearer %s".formatted(token);

        when(httpServletRequest.getHeader(anyString()))
            .thenReturn(requestToken);

        when(tokenService.validate(token))
            .thenReturn(token);

        sut.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        verify(tokenService).validate(token);
        verify(authenticatioService).setSpringUserAuth(anyString());
    }

    @ParameterizedTest
    @MethodSource("sourceNotSetSpringContext")
    void shouldNotSetSpringContext(String token) throws ServletException, IOException {
        when(httpServletRequest.getHeader(anyString()))
            .thenReturn(token);

        sut.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        verify(authenticatioService, never())
            .setSpringUserAuth(anyString());
    }

    private static Stream<Arguments> sourceNotSetSpringContext() {
        return Stream.of(
            Arguments.of(StringUtils.EMPTY),
            Arguments.of(StringUtils.CR),
            Arguments.of(StringUtils.LF),
            Arguments.of(StringUtils.SPACE)
        );
    }
}