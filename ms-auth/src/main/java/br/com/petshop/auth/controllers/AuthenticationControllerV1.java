package br.com.petshop.auth.controllers;

import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
import br.com.petshop.auth.model.dto.TokenRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import br.com.petshop.auth.service.CreateAuthenticationService;
import br.com.petshop.auth.service.DeleteAuthenticationService;
import br.com.petshop.auth.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/v1")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Endpoint for authentication")
public class AuthenticationControllerV1 {

    private final TokenService tokenService;

    private final CreateAuthenticationService createService;

    private final DeleteAuthenticationService deleteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create the authentication")
    public ResponseEntity<Void> create(@RequestBody CreateAuthenticationRequestDTO dto) {
        this.createService.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Return token for authenticated user")
    public ResponseEntity<TokenResponseDTO> getToken(@RequestBody TokenRequestDTO dto) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{enrollment}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Remove authentication")
    public ResponseEntity<Void> delete(@PathVariable String enrollment) {
        return ResponseEntity.ok().build();
    }
}
