package br.com.petshop.auth.service;

import br.com.petshop.auth.helper.UserHelper;
import br.com.petshop.auth.infra.security.UserRepository;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

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
        var dto = helper.createAuthenticationRequestValid();

        sut.create(dto);

        verify(userRepository).existsUserByEnrollment(dto.enrollment());
        verify(userRepository).save(any());
    }

    @ParameterizedTest
    @MethodSource("sourceCreateWithError")
    void shouldCreateWithError(CreateAuthenticationRequestDTO dto) {
        assertThrows(ResponseStatusException.class, () -> {
            sut.create(dto);
        });
    }

    private static Stream<Arguments> sourceCreateWithError() {
        var helper = new UserHelper();

        var dtoWithNullRoles = helper.createAuthenticationWithoutRoles();
        var dtoWithEmptyRoles = helper.createAuthenticationWithEmptyRoles();
        var dtoWithRoleAdmin = helper.createAuthenticationWithAdminRoles();

        return Stream.of(
            Arguments.of(dtoWithNullRoles),
            Arguments.of(dtoWithEmptyRoles),
            Arguments.of(dtoWithRoleAdmin)
        );
    }

    @Test
    void shouldCreateThatAlreadExistEnrollement() {
        var dto = helper.createAuthenticationRequestValid();

        Mockito.when(userRepository.existsUserByEnrollment(dto.enrollment()))
                .thenReturn(true);

        assertThrows(ResponseStatusException.class, () -> {
            sut.create(dto);
        });
    }
}