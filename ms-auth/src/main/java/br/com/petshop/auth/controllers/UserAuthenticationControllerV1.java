package br.com.petshop.auth.controllers;

import br.com.petshop.auth.controllers.dto.LoginRequestDTO;
import br.com.petshop.auth.controllers.dto.TokenRequestDTO;
import br.com.petshop.auth.controllers.dto.TokenResponseDTO;
import br.com.petshop.auth.services.LoginService;
import br.com.petshop.auth.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
@RequiredArgsConstructor
@Tag(name = "Endpoint for authentication")
public class UserAuthenticationControllerV1 {

    private final LoginService loginService;

    private final TokenService tokenService;

    @GetMapping
    @Operation(summary = "Do authentication for a user")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        var tokenDTO = loginService.login(dto);
        return ResponseEntity.ok(tokenDTO);
    }

    @PatchMapping("/token")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Refresh token")
    public ResponseEntity<TokenResponseDTO> refresh(@RequestBody TokenRequestDTO dto) {
        var token = tokenService.refresh(dto);
        return ResponseEntity.ok(TokenResponseDTO.createWithNow(token));
    }
}
