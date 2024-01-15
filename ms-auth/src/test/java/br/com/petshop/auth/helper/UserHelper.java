package br.com.petshop.auth.helper;

import br.com.petshop.auth.model.Role;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;

import java.util.List;

public class UserHelper {

    public static final String ENROLLMENT = "1245";

    public static final String PASS = "1asf123av";

    private RoleHelper roleHelper;

    public UserHelper() {
        this.roleHelper = new RoleHelper();
    }

    public CreateAuthenticationRequestDTO createAuthenticationRequestValid() {
        var user = createUserValid();
        var dto = new CreateAuthenticationRequestDTO(
            user.getEnrollment(),
            user.getPass(),
            List.of("user")
        );
        return dto;
    }

    public User createUserValid() {
        return User.builder()
            .id(123)
            .enrollment("1234")
            .pass("asd123")
            .roles(createValidRoles())
            .build();
    }

    public List<Role> createValidRoles() {
        return this.roleHelper.createValidRoles();
    }
}
