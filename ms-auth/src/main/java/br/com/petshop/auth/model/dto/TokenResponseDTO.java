package br.com.petshop.auth.model.dto;

import java.time.LocalDateTime;

public record TokenResponseDTO(LocalDateTime time, String token, String refresh) {
}
