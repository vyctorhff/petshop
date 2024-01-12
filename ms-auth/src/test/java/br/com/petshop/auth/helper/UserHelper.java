package br.com.petshop.auth.helper;

import br.com.petshop.auth.model.Role;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;

import java.util.List;

public class UserHelper {

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
        return List.of(
            Role.builder()
                .id(123)
                .name("user")
                .build(),
            Role.builder()
                .id(456)
                .name("employee")
                .build(),
            Role.builder()
                .id(678)
                .name("admin")
                .build()
        );
    }
}