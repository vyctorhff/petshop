package br.com.petshop.auth.infra.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticatioService implements UserDetailsService {

    private final UserAuthenticationRepository repository;

    @Override
    public UserDetails loadUserByUsername(String enrollment) throws UsernameNotFoundException {
        return repository.findByEnrollment(enrollment);
    }
}