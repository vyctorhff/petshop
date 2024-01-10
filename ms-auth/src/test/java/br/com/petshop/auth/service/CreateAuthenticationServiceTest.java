package br.com.petshop.auth.service;

import br.com.petshop.auth.helper.UserHelper;
import br.com.petshop.auth.infra.security.UserRepository;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class CreateAuthenticationServiceTest {

    @InjectMocks
    private CreateAuthenticationService sut;

    @Mock
    private UserRepository userRepository;

    private UserHelper helper;

    @BeforeEach
    void setUp() {
        this.helper = new UserHelper();
    }

    @Test
    void shouldCreateUserSuccessfully() {
        var dto = new CreateAuthenticationRequestDTO();
        sut.create();
    }
}