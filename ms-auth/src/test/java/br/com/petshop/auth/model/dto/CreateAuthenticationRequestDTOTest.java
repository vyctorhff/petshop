package br.com.petshop.auth.model.dto;

import br.com.petshop.auth.helper.UserHelper;
import br.com.petshop.auth.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateAuthenticationRequestDTOTest {

    private UserHelper helper;

    @BeforeEach
    void setUp() {
        this.helper = new UserHelper();
    }

    @Test
    void shouldToEntitySuccessfully() {
        CreateAuthenticationRequestDTO request = this.helper.createAuthenticationRequestValid();
        User entity = request.toEntity();

        assertNotNull(entity);
        assertEquals(request.enrollment(), entity.getEnrollment());
        assertEquals(request.password(), entity.getPass());
        assertEquals(request.roles().size(), entity.getRoles().size());
    }

    @Test
    void shouldToEntityWithNoRoles() {
        CreateAuthenticationRequestDTO request = this.helper.createAuthenticationWithoutRoles();
        User entity = request.toEntity();

        assertNotNull(entity);

        assertEquals(request.enrollment(), entity.getEnrollment());
        assertEquals(request.password(), entity.getPass());

        assertNotNull(entity.getRoles());
        assertEquals(0, entity.getRoles().size());
    }
}