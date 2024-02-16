package br.com.petshop.auth.controllers;

import br.com.petshop.auth.infra.RoleRepository;
import br.com.petshop.auth.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role/v1")
@RequiredArgsConstructor
public class RoleControllerV1 {

    private final RoleRepository repository;

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        // TODO: create dto
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/name")
    public ResponseEntity<Role> findByName(String name) {
        // TODO: create dto
        return ResponseEntity.ok(repository.findRoleByName(name));
    }
}
