package br.com.petshop.auth.infra.security;

import br.com.petshop.auth.model.Roles;
import br.com.petshop.auth.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class UserAuthentication implements UserDetails {

    private User user;

    public UserAuthentication(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (Roles.ADMIN.getName().equals(user.getName())) {
            return List.of(
                new SimpleGrantedAuthority("admin")
            );
        }

        return List.of(
            new SimpleGrantedAuthority("user"),
            new SimpleGrantedAuthority("employee")
        );
    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return String.valueOf(user.getEnrollment());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
