package br.com.petshop.auth.infra.security;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@UtilityClass
public class UserSpringContext {

    // TODO: check this class later

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static List<String> getAuthorities() {
        return getAuthentication().getAuthorities().stream()
            .map(value -> value.getAuthority())
            .toList();
    }
}
