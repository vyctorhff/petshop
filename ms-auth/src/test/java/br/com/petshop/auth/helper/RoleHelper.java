package br.com.petshop.auth.helper;

import br.com.petshop.auth.model.Role;
import br.com.petshop.auth.model.Roles;

import java.util.List;

public class RoleHelper {

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

    public List<String> createStringRole() {
        return Roles.toStringList();
    }
}
