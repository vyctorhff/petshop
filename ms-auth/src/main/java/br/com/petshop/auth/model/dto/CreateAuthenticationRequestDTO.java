package br.com.petshop.auth.model.dto;

import br.com.petshop.auth.model.User;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public record CreateAuthenticationRequestDTO(
    String enrollment,
    String password,
    List<String> roles
) {

    public User toEntity() {
        throw new NotImplementedException("not implemented");
    }
}
