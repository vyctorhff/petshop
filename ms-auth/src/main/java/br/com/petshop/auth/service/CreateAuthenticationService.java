package br.com.petshop.auth.service;

import br.com.petshop.auth.infra.security.UserRepository;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAuthenticationService {

    private final UserRepository repository;

    public User create(CreateAuthenticationRequestDTO dto) {
        log.info("Creating authentication");

        User entity = dto.toEntity();

        if (repository.existsUserByEnrollment(entity.getEnrollment())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enrollment already exists");
        }

        if (!entity.hasRoles()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing roles");
        }

        if (entity.hasAdminRole()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "it cannot has admin role");
        }

        return repository.save(dto.toEntity());
    }
}
