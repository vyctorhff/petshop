package br.com.petshop.auth.controllers;

import br.com.petshop.auth.model.dto.TokenRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import br.com.petshop.auth.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token/v1")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Endpoint for token")
public class TokenControllerV1 {

    private final TokenService tokenService;

    @PatchMapping
    @Operation(summary = "Refresh token")
    public ResponseEntity<TokenResponseDTO> refresh(@RequestBody TokenRequestDTO dto) {
        tokenService.refresh();
        return ResponseEntity.ok().build();
    }
}
