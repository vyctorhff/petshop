package br.com.petshop.auth.controllers;

import br.com.petshop.auth.infra.UserRepository;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import br.com.petshop.auth.model.dto.UserResponseDTO;
import br.com.petshop.auth.services.CreateAuthenticationService;
import br.com.petshop.auth.services.DeleteAuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
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

import java.util.List;

@RestController
@RequestMapping("/user/v1")
@RequiredArgsConstructor
public class UserControllerV1 {

    private final CreateAuthenticationService createService;

    private final DeleteAuthenticationService deleteService;

    private final UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create the authentication")
    public ResponseEntity<TokenResponseDTO> create(@RequestBody CreateAuthenticationRequestDTO dto) {
        var tokenDTO = createService.create(dto);
        return ResponseEntity.ok(tokenDTO);
    }

    @GetMapping("/{enrollment}")
    @Operation(summary = "Find user by enrollment")
    public ResponseEntity<UserResponseDTO> findUser(@PathVariable Integer enrollment) {
        User user = userRepository.findByEnrollment(enrollment);
        return ResponseEntity.ok(UserResponseDTO.fromEntity(user));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<User> users = userRepository.findAll();

        List<UserResponseDTO> result = users.stream()
            .map(UserResponseDTO::fromEntity)
            .toList();

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{enrollment}")
    @Operation(summary = "Remove authentication")
    public ResponseEntity<Void> delete(@PathVariable Integer enrollment) {
        this.deleteService.process(enrollment);
        return ResponseEntity.noContent().build();
    }
}
