package br.com.petshop.auth.services;

import br.com.petshop.auth.infra.UserRepository;
import br.com.petshop.auth.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class DeleteUserServiceTest {

    @InjectMocks
    private DeleteUserService sut;

    @Mock
    private UserRepository repository;

    @Test
    void shouldDeleteSuccessfully() {
        User user = new User();
        when(repository.findByEnrollment(1))
            .thenReturn(user);

        sut.process(1);

        verify(repository, atMostOnce()).delete(user);
        verify(repository, atMostOnce()).findByEnrollment(1);
    }

    @ParameterizedTest
    @MethodSource("sourceNotDeleteWhenNotExists")
    void shouldNotDeleteWhenNotExists(Integer enrollment) {
        assertThrows(ResponseStatusException.class, () -> {
            sut.process(enrollment);
        });
    }

    private static Stream<Arguments> sourceNotDeleteWhenNotExists() {
        Integer nullable = null;
        return Stream.of(
            Arguments.of(nullable),
            Arguments.of(-1),
            Arguments.of(0),
            Arguments.of(1)
        );
    }
}