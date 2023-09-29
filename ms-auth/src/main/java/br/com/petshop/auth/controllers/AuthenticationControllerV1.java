package br.com.petshop.auth.controllers;

import br.com.petshop.auth.controllers.dto.CreateAuthenticationRequestDTO;
import br.com.petshop.auth.controllers.dto.TokenRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@Slf4j
@Tag(name = "Endpoint for authentication")
public class AuthenticationController {

    @PostMapping
    @Operation(summary = "Create the authentication")
    public ResponseEntity<Void> create(@RequestBody CreateAuthenticationRequestDTO dto) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Return token for authenticated user")
    public boolean getToken(@RequestBody TokenRequestDTO dto) {
        return false;
    }

    @DeleteMapping("${}")
    @Operation
    public ResponseEntity<Void> delete(@PathVariable("") String enrollment) {
        return ResponseEntity.ok().build();
    }
}
