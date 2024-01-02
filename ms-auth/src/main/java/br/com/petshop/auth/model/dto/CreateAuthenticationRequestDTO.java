package br.com.petshop.auth.model.dto;

import br.com.petshop.auth.model.Role;
import br.com.petshop.auth.model.User;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public record CreateAuthenticationRequestDTO(
    String enrollment,
    String password,
    List<String> roles
) {

    public User toEntity() {

        List<Role> rolesEntity = new ArrayList<>();
        if (rolesEntity != null) {
            roles.forEach(roleStr -> {
                var role = Role.builder()
                    .name(roleStr)
                    .build();

                rolesEntity.add(role);
            });
        }

        var user = User
            .builder()
            .enrollment(enrollment)
            .pass(password)
            .roles(rolesEntity)
            .build();


        throw new NotImplementedException("not implemented");
    }
}
