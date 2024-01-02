package br.com.petshop.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity(name = "tb_role")
public class Role {

    @Id
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
