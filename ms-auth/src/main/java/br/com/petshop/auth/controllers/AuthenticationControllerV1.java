package br.com.petshop.auth.controllers;

import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
import br.com.petshop.auth.model.dto.LoginRequestDTO;
import br.com.petshop.auth.service.CreateAuthenticationService;
import br.com.petshop.auth.service.DeleteAuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/v1")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Endpoint for authentication")
public class AuthenticationControllerV1 {

    private final CreateAuthenticationService createService;

    private final DeleteAuthenticationService deleteService;

    private final AuthenticationManager authenticationManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create the authentication")
    public ResponseEntity<Void> create(@RequestBody CreateAuthenticationRequestDTO dto) {
        this.createService.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Do authentication for a user")
    public ResponseEntity<Void> login(@RequestBody LoginRequestDTO dto) {
        var user = new UsernamePasswordAuthenticationToken(dto.enrollment(), dto.password());
        Authentication authenticate = this.authenticationManager.authenticate(user);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{enrollment}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Remove authentication")
    public ResponseEntity<Void> delete(@PathVariable String enrollment) {
        this.deleteService.process(enrollment);
        return ResponseEntity.ok().build();
    }
}
