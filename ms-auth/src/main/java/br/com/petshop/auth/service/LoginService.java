package br.com.petshop.auth.service;

import br.com.petshop.auth.infra.security.UserAuthentication;
import br.com.petshop.auth.model.dto.LoginRequestDTO;
import br.com.petshop.auth.model.dto.TokenResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public TokenResponseDTO login(LoginRequestDTO dto) {
        var user = new UsernamePasswordAuthenticationToken(dto.enrollment(), dto.password());
        var authenticate = this.authenticationManager.authenticate(user);

        UserAuthentication principal = (UserAuthentication) authenticate.getPrincipal();
        var token = tokenService.generate(principal.getUser());

        return TokenResponseDTO.createWithNow(token);
    }
}
