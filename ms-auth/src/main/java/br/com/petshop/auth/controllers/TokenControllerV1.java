package br.com.petshop.auth.controllers;

import br.com.petshop.auth.controllers.dto.TokenRequestDTO;
import br.com.petshop.auth.controllers.dto.TokenResponseDTO;
import br.com.petshop.auth.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token/v1")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Endpoint for token")
public class TokenControllerV1 {

    private final TokenService tokenService;

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Refresh token")
    public ResponseEntity<TokenResponseDTO> refresh(@RequestBody TokenRequestDTO dto) {
        var token = tokenService.refresh(dto);
        return ResponseEntity.ok(TokenResponseDTO.createWithNow(token));
    }
}
