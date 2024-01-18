package br.com.petshop.auth.model.dto;

import br.com.petshop.auth.model.Role;
import br.com.petshop.auth.model.User;

import java.util.ArrayList;
import java.util.List;

public record CreateAuthenticationRequestDTO(
    String enrollment,
    String password,
    List<String> roles
) {

    public User toEntity() {
        List<Role> rolesEntity = new ArrayList<>();

        if (roles != null) {
            roles.forEach(roleStr -> {
                var role = Role.builder()
                    .name(roleStr)
                    .build();

                rolesEntity.add(role);
            });
        }

        return User
            .builder()
            .enrollment(enrollment)
            .pass(password)
            .roles(rolesEntity)
            .build();
    }
}
