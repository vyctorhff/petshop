package br.com.petshop.auth.service;

import br.com.petshop.auth.infra.security.UserRepository;
import br.com.petshop.auth.model.dto.CreateAuthenticationRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAuthenticationService {

    private final UserRepository repository;

    public void create(CreateAuthenticationRequestDTO dto) {
        log.info("Creating authentication");
        repository.save(dto.toEntity());
    }
}
