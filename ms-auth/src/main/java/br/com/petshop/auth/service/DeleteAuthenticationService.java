package br.com.petshop.auth.service;

import br.com.petshop.auth.infra.UserRepository;
import br.com.petshop.auth.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteAuthenticationService {

    private final UserRepository repository;

    public void process(Integer enrollment) {
        if (enrollment == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        User user = repository.findByEnrollment(enrollment);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        repository.delete(user);
    }
}
