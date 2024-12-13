package br.com.petshop.auth.controllers.dto;

import br.com.petshop.auth.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDTO {

    private String name;

    public static RoleResponseDTO fromEntity(Role role) {
        return new RoleResponseDTO(role.getName());
    }
}
