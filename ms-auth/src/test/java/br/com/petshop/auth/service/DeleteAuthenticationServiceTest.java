package br.com.petshop.auth.service;

import br.com.petshop.auth.infra.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class DeleteAuthenticationServiceTest {

    @InjectMocks
    private DeleteAuthenticationService sut;

    @Mock
    private UserRepository repository;

    @Test
    void shouldDeleteSuccessfully() {
        fail("to test");
    }
}