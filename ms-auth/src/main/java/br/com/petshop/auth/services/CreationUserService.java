package br.com.petshop.auth.services;

import br.com.petshop.auth.infra.EnrollmentNextValueRepository;
import br.com.petshop.auth.infra.RoleRepository;
import br.com.petshop.auth.infra.UserRepository;
import br.com.petshop.auth.model.Role;
import br.com.petshop.auth.model.User;
import br.com.petshop.auth.controllers.dto.CreateAuthenticationRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreationUserService {

    private final UserRepository repository;

    private final RoleRepository roleRepository;

    private final EnrollmentNextValueRepository enrollmentNextValueRepository;

    public User create(CreateAuthenticationRequestDTO dto) {
        User entity = dto.toEntity();
        entity.setEnrollment(enrollmentNextValueRepository.next());
        entity.setCreatedAt(LocalDateTime.now());

        validate(entity);
        preperRoles(entity);

        return repository.save(entity);
    }

    private void preperRoles(User entity) {
        List<Role> roles = roleRepository.findAll();

        var allIn = entity.getRoles().stream()
            .anyMatch(roles::contains);

        if (!allIn) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "role does not exists");
        }

        // fill roles from database in the entity
        var rolesFromDataBase = roles.stream()
            .filter(role -> entity.getRoles().contains(role))
            .toList();

        entity.setRoles(rolesFromDataBase);
    }

    private void validate(User entity) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        if (!entity.hasRoles()) {
            throw new ResponseStatusException(badRequest, "missing roles");
        }

        if (entity.hasAdminRole()) {
            throw new ResponseStatusException(badRequest, "it cannot has admin role");
        }
    }
}
