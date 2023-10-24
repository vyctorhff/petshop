package br.com.petshop.auth.service;

import br.com.petshop.auth.model.User;
import br.com.petshop.auth.model.dto.TokenRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final AuthenticationManager authenticationManager;

    public TokenResponseDTO login(TokenRequestDTO requestDTO) {
        var auth = this.getAuthetication(requestDTO);
        var user = (User) auth.getDetails();

        // TODO: continue
        var token = "";
        var refreshToken = "";

        return new TokenResponseDTO(LocalDateTime.now(), token, refreshToken);
    }

    public Authentication getAuthetication(TokenRequestDTO requestDTO) {
        var userPassword = new UsernamePasswordAuthenticationToken(requestDTO.enrollment(), requestDTO.password());
        return this.authenticationManager.authenticate(userPassword);
    }

    
}
