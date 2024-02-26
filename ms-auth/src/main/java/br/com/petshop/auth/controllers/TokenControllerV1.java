package br.com.petshop.auth.controllers;

import br.com.petshop.auth.model.dto.TokenRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import br.com.petshop.auth.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    @Operation(summary = "Return token for authenticated user")
    public ResponseEntity<TokenResponseDTO> getToken(@RequestBody TokenRequestDTO dto) {
        // REFACT: check if this route is necessarily
//        tokenService.getAuthetication(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Refresh token")
    public ResponseEntity<TokenResponseDTO> refresh(@RequestBody TokenRequestDTO dto) {
        tokenService.refresh();
        return ResponseEntity.ok().build();
    }
}
