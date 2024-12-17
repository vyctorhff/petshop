package br.com.petshop.auth.services;

import br.com.petshop.auth.helper.RoleHelper;
import br.com.petshop.auth.helper.UserHelper;
import br.com.petshop.auth.infra.EnrollmentNextValueRepository;
import br.com.petshop.auth.infra.RoleRepository;
import br.com.petshop.auth.infra.UserRepository;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.controllers.dto.CreateAuthenticationRequestDTO;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class CreateAuthenticationServiceTest {

    @InjectMocks
    private CreateAuthenticationService sut;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private EnrollmentNextValueRepository enrollmentNextValueRepository;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    private UserHelper helper;

    private RoleHelper roleHelper;

    @BeforeEach
    void setUp() {
        this.helper = new UserHelper();
        this.roleHelper = new RoleHelper();
    }

    @Test
    void shouldCreateUserSuccessfully() {
        when(enrollmentNextValueRepository.next())
            .thenReturn(1);

        when(roleRepository.findAll())
            .thenReturn(roleHelper.createValidRoles());

        var dto = helper.createAuthenticationRequestValid();

        sut.create(dto);

        verify(enrollmentNextValueRepository, Mockito.only()).next();
        verify(roleRepository, Mockito.only()).findAll();
        verify(userRepository).save(userArgumentCaptor.capture());

        var user = userArgumentCaptor.getValue();

        assertNotNull(user);
        assertEquals(1, user.getEnrollment());
        assertNotNull(user.getCreatedAt());

        user.getRoles().forEach(role -> {
            assertNotNull(role);
            assertNotNull(role.getId());
        });
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

    @Test
    void shouldNotCreateWitRoleThatNotExists() {
        when(enrollmentNextValueRepository.next())
            .thenReturn(1);

        when(roleRepository.findAll())
            .thenReturn(roleHelper.createValidRoles());

        var dto = helper.createAuthenticationWithRoleNotExists();

        assertThrows(ResponseStatusException.class, () -> sut.create(dto));
    }
}