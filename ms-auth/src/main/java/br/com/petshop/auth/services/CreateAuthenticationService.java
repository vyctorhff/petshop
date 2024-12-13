package br.com.petshop.auth.services;

import br.com.petshop.auth.controllers.dto.CreateAuthenticationRequestDTO;
import br.com.petshop.auth.controllers.dto.TokenResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAuthenticationService {

    private final CreationUserService creationUserService;

    private final TokenService tokenService;

    public TokenResponseDTO create(CreateAuthenticationRequestDTO dto) {
        log.info("Creating authentication");

        var user = this.creationUserService.create(dto);
        var token = tokenService.generate(user);

        return TokenResponseDTO.createWithNow(token);
    }
}
