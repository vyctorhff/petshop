package br.com.petshop.auth.model.dto;

import br.com.petshop.auth.model.User;

import java.util.List;

public record CreateAuthenticationRequestDTO(
    String enrollment,
    String password,
    List<String> rules
) {

    public User toEntity() {
        return null;
    }
}
