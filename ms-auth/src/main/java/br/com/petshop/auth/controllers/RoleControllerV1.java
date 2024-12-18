package br.com.petshop.auth.controllers;

import br.com.petshop.auth.infra.RoleRepository;
import br.com.petshop.auth.controllers.dto.RoleResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role/v1")
@RequiredArgsConstructor
public class RoleControllerV1 {

    private final RoleRepository repository;

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAll() {
        List<RoleResponseDTO> list = repository.findAll()
            .stream()
            .map(RoleResponseDTO::fromEntity)
            .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/find/{name}/name")
    public ResponseEntity<RoleResponseDTO> findByName(@PathVariable("name") String name) {
        var dto = RoleResponseDTO.fromEntity(repository.findRoleByName(name));
        return ResponseEntity.ok(dto);
    }
}
