package br.com.petshop.auth.model.dto;

public record CreateAuthenticationRequestDTO(
    String enrollment,
    String password
) {
}
