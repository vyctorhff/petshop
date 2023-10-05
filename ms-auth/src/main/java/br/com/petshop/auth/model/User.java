package br.com.petshop.auth.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String enrollment;

    private String pass;

    private List<String> roles;
}
