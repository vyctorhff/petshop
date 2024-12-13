package br.com.petshop.auth.controllers.dto;

import br.com.petshop.auth.model.Role;
import br.com.petshop.auth.model.User;

import java.util.ArrayList;
import java.util.List;

public record CreateAuthenticationRequestDTO(
    String name,
    String alias,
    String password,
    List<String> roles
) {

    public User toEntity() {
        List<Role> rolesEntity = new ArrayList<>();

        if (roles != null) {
            rolesEntity = roles.stream()
                .map(value -> new Role(value))
                .toList();
        }

        return User
            .builder()
            .name(name)
            .alias(alias)
            .pass(password)
            .roles(rolesEntity)
            .build();
    }
}
