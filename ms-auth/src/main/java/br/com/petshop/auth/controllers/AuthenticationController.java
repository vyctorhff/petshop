package br.com.petshop.auth.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Slf4j
@Tag(name = "Endpoint for authentication")
public class AuthenticationController {

    @GetMapping
    @Operation(summary = "testando testando")
    public boolean teste() {
        return false;
    }
}
