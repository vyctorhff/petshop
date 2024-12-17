package br.com.petshop.auth.helper;

import br.com.petshop.auth.model.Role;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.controllers.dto.CreateAuthenticationRequestDTO;

import java.util.List;

public class UserHelper {

    public static final String ENROLLMENT = "1245";

    public static final String NAME = "Name name";

    public static final String ALIAS = "alias";

    public static final String PASS = "1asf123av";

    private RoleHelper roleHelper;

    public UserHelper() {
        this.roleHelper = new RoleHelper();
    }

    public CreateAuthenticationRequestDTO createAuthenticationRequestValid() {
        return new CreateAuthenticationRequestDTO(
            NAME,
            ALIAS,
            PASS,
            List.of("user")
        );
    }

    public CreateAuthenticationRequestDTO createAuthenticationWithoutRoles() {
        return new CreateAuthenticationRequestDTO(
            NAME,
            ALIAS,
            PASS,
            null
        );
    }

    public CreateAuthenticationRequestDTO createAuthenticationWithEmptyRoles() {
        return new CreateAuthenticationRequestDTO(
            NAME,
            ALIAS,
            PASS,
            List.of()
        );
    }

    public CreateAuthenticationRequestDTO createAuthenticationWithAdminRoles() {
        return new CreateAuthenticationRequestDTO(
            NAME,
            ALIAS,
            PASS,
            List.of("admin")
        );
    }

    public CreateAuthenticationRequestDTO createAuthenticationWithEnrollment() {
        return new CreateAuthenticationRequestDTO(
            NAME,
            ALIAS,
            PASS,
            List.of("admin")
        );
    }

    public CreateAuthenticationRequestDTO createAuthenticationWithRoleNotExists() {
        return new CreateAuthenticationRequestDTO(
            NAME,
            ALIAS,
            PASS,
            List.of("role test")
        );
    }

    public User createUserValid() {
        return User.builder()
            .id(123)
            .pass("asd123")
            .roles(createValidRoles())
            .build();
    }

    public List<Role> createValidRoles() {
        return this.roleHelper.createValidRoles();
    }
}
