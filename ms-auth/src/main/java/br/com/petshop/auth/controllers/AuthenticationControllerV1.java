package br.com.petshop.auth.controllers;

import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
import br.com.petshop.auth.model.dto.LoginRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import br.com.petshop.auth.service.CreateAuthenticationService;
import br.com.petshop.auth.service.LoginService;
import br.com.petshop.auth.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/v1")
@RequiredArgsConstructor
@Tag(name = "Endpoint for authentication")
public class AuthenticationControllerV1 {

    private final CreateAuthenticationService createService;

    private final LoginService loginService;

    private final TokenService tokenService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create the authentication")
    public ResponseEntity<TokenResponseDTO> create(@RequestBody CreateAuthenticationRequestDTO dto) {
        var user = this.createService.create(dto);
        var token = tokenService.generate(user);

        var tokenDTO = TokenResponseDTO.createWithNow(token);
        return ResponseEntity.ok(tokenDTO);
    }

    @GetMapping
    @Operation(summary = "Do authentication for a user")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        var tokenDTO = loginService.login(dto);
        return ResponseEntity.ok(tokenDTO);
    }
}
