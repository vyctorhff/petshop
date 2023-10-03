package br.com.petshop.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain security(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .authorizeHttpRequests(registry -> {
                registry.anyRequest().authenticated();
//                registry.requestMatchers("/auth/v1/create").permitAll();
//                registry.requestMatchers("/auth/v1/token").permitAll();
            })
            .build();
    }
}
