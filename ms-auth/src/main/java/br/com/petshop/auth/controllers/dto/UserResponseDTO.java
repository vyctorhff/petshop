package br.com.petshop.auth.controllers.dto;

import br.com.petshop.auth.model.User;

import java.time.LocalDateTime;

public record UserResponseDTO(
    Integer enrollment,
    String name,
    String alias,
    LocalDateTime create
) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
            user.getEnrollment(),
            user.getName(),
            user.getAlias(),
            user.getCreatedAt()
        );
    }
}
