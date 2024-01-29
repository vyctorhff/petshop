package br.com.petshop.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private Integer id;

    private Integer enrollment;

    private String pass;

    private String name;

    private String alias;

    private LocalDateTime createdAt;

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
            .anyMatch(role -> Roles.hasAdminName(role.getName()));
    }

    public String getEnrollmentAsString() {
        return String.valueOf(this.enrollment);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("name", name)
            .build();
    }
}
