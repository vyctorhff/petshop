package br.com.petshop.auth.service;

import br.com.petshop.auth.helper.UserHelper;
import br.com.petshop.auth.infra.security.EnrollmentNextValueRepository;
import br.com.petshop.auth.infra.security.UserRepository;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class CreateAuthenticationServiceTest {

    @InjectMocks
    private CreateAuthenticationService sut;

    @Mock
    private UserRepository userRepository;

    @Mock
    private EnrollmentNextValueRepository enrollmentNextValueRepository;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    private UserHelper helper;

    @BeforeEach
    void setUp() {
        this.helper = new UserHelper();
    }

    @Test
    void shouldCreateUserSuccessfully() {
        when(enrollmentNextValueRepository.next())
            .thenReturn(1);

        var dto = helper.createAuthenticationRequestValid();

        sut.create(dto);

        verify(enrollmentNextValueRepository).next();
        verify(userRepository).save(userArgumentCaptor.capture());

        var user = userArgumentCaptor.getValue();

        assertNotNull(user);
        assertEquals(1, user.getEnrollment());
    }

    @ParameterizedTest
    @MethodSource("sourceCreateWithError")
    void shouldCreateWithError(CreateAuthenticationRequestDTO dto) {
        assertThrows(ResponseStatusException.class, () -> sut.create(dto));
    }

    private static Stream<Arguments> sourceCreateWithError() {
        var helper = new UserHelper();

        var dtoWithNullRoles = helper.createAuthenticationWithoutRoles();
        var dtoWithEmptyRoles = helper.createAuthenticationWithEmptyRoles();
        var dtoWithRoleAdmin = helper.createAuthenticationWithAdminRoles();
        var dtoWithRoleEnrollment = helper.createAuthenticationWithEnrollment();

        return Stream.of(
            Arguments.of(dtoWithNullRoles),
            Arguments.of(dtoWithEmptyRoles),
            Arguments.of(dtoWithRoleEnrollment),
            Arguments.of(dtoWithRoleAdmin)
        );
    }
}