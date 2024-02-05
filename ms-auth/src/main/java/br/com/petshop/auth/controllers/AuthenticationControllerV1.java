package br.com.petshop.auth.controllers;

import br.com.petshop.auth.infra.UserRepository;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
import br.com.petshop.auth.model.dto.LoginRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import br.com.petshop.auth.model.dto.UserResponseDTO;
import br.com.petshop.auth.service.CreateAuthenticationService;
import br.com.petshop.auth.service.DeleteAuthenticationService;
import br.com.petshop.auth.service.LoginService;
import br.com.petshop.auth.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final LoginService loginService;

    private final TokenService tokenService;

    private final UserRepository userRepository;

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

    @GetMapping("/{enrollment}")
    @Operation(summary = "Find user by enrollment")
    public ResponseEntity<UserResponseDTO> findUser(@PathVariable Integer enrollment) {
        User user = userRepository.findByEnrollment(enrollment);
        return ResponseEntity.ok(UserResponseDTO.fromEntity(user));
    }

    @DeleteMapping("/{enrollment}")
    @Operation(summary = "Remove authentication")
    public ResponseEntity<Void> delete(@PathVariable Integer enrollment) {
        this.deleteService.process(enrollment);
        return ResponseEntity.noContent().build();
    }
}
