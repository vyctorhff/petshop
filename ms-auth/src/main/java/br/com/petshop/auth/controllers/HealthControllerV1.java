package br.com.petshop.auth.controllers;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthControllerV1 {

    @GetMapping
    public Health health() {
        return Health.status(Status.UP).build();
    }
}
