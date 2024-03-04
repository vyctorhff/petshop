package br.com.petshop.auth.infra.security;

import br.com.petshop.auth.infra.UserRepository;
import br.com.petshop.auth.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticatioService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String enrollment) throws UsernameNotFoundException {
        User user = repository.findByEnrollment(Integer.parseInt(enrollment));
        return new UserAuthentication(user);
    }

    public void setSpringUserAuth(String enrollment) throws UsernameNotFoundException {
        UserDetails userDetails = this.loadUserByUsername(enrollment);
        var userAuth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(userAuth);
    }
}