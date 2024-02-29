package br.com.petshop.auth.controllers;

import br.com.petshop.auth.infra.RoleRepository;
import br.com.petshop.auth.services.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoleControllerV1.class)
class RoleControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleRepository repository;

    @MockBean
    private TokenService tokenService;

    @Test
    void shouldGetAll() throws Exception {
        // FIXME: error test
        mockMvc.perform(MockMvcRequestBuilders.get("/role/v1"))
            .andExpect(status().isOk());
    }
}