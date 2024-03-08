package br.com.petshop.auth.controllers;

import br.com.petshop.auth.model.dto.LoginRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import br.com.petshop.auth.services.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/v1")
@RequiredArgsConstructor
@Tag(name = "Endpoint for authentication")
public class AuthenticationControllerV1 {

    private final LoginService loginService;

    @GetMapping
    @Operation(summary = "Do authentication for a user")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        var tokenDTO = loginService.login(dto);
        return ResponseEntity.ok(tokenDTO);
    }
}
