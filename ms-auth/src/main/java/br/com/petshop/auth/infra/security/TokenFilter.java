package br.com.petshop.auth.infra.security;

import br.com.petshop.auth.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class TokenFilter extends OncePerRequestFilter {

    public static final String AUTH_BEARER = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticatioService authenticatioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
        throws ServletException, IOException {

        var optToken = getTokenOnly(request);

        if (optToken.isPresent()) {
            var subject = tokenService.validate(optToken.get());

//            UserDetails userDetails = authenticatioService.loadUserByUsername(subject);
//            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            authenticatioService.setSpringUserAuth(subject);
        }

        filterChain.doFilter(request, response);
    }

    private Optional<String> getTokenOnly(HttpServletRequest request) {
        var token = request.getHeader(AUTHORIZATION);

        if (StringUtils.isBlank(token)) {
            return Optional.empty();
        }

        var tokenOnly = token.trim().replace(AUTH_BEARER, StringUtils.EMPTY);
        return Optional.of(tokenOnly);
    }
}
