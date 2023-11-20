package br.com.petshop.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_user")
public class User {

    @Id
    private Integer id;

    private String enrollment;

    private String pass;
}
