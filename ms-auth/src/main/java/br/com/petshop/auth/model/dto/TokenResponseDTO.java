package br.com.petshop.auth.model.dto;

import java.time.LocalDateTime;

public record TokenResponseDTO(LocalDateTime time, String token, String refresh) {

    public static TokenResponseDTO createWithNow(String token, String refresh) {
        return new TokenResponseDTO(LocalDateTime.now(), token, refresh);
    }
}
