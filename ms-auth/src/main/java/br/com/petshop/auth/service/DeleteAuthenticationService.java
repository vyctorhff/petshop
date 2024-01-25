package br.com.petshop.auth.service;

import br.com.petshop.auth.infra.security.UserRepository;
import br.com.petshop.auth.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteAuthenticationService {

    private final UserRepository repository;

    public void process(Integer enrollment) {
        User user = repository.findByEnrollment(enrollment);

        if (user == null) return;

        repository.delete(user);
    }
}
