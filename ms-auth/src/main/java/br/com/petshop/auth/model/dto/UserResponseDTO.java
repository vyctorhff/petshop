package br.com.petshop.auth.model.dto;

import br.com.petshop.auth.model.User;

public record UserResponseDTO(
    Integer enrollment,
    String name,
    String alias
) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
            user.getEnrollment(),
            user.getName(),
            user.getAlias()
        );
    }
}
