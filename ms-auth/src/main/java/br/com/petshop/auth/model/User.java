package br.com.petshop.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity(name = "tb_user")
@Builder
public class User {

    @Id
    private Integer id;

    private String enrollment;

    private String pass;

    @ManyToMany
    @JoinTable(
        name = "tb_user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public boolean hasRoles() {
        return roles != null && !roles.isEmpty();
    }

    public boolean hasAdminRole() {
        return hasRoles() && roles.stream()
            .anyMatch(value -> Roles.ADMIN.toString().equals(value.getName().toUpperCase()));
    }
}
