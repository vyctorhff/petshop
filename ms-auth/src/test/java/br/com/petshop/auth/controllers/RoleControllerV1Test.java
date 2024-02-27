package br.com.petshop.auth.controllers;

import br.com.petshop.auth.infra.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(RoleControllerV1.class)
class RoleControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleRepository repository;

    // TODO: working progress
}