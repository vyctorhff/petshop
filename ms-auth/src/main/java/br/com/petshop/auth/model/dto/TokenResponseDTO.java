package br.com.petshop.auth.controllers.dto;

import java.time.LocalDateTime;

public record TokenResponseDTO(LocalDateTime time, String token, String refresh) {
}
