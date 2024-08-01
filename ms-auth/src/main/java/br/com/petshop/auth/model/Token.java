package br.com.petshop.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_token")
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    private String token;

    private String refresh;

    private LocalDateTime createdAt;

    public Token(User user, String token) {
        this.refresh = UUID.randomUUID().toString();
        this.token = token;

        this.updateCreateAt();
    }

    public boolean isValid() {
        return LocalDateTime.now().getDayOfYear() == createdAt.getDayOfYear();
    }

    public boolean checkEnrollment(Integer enrollment) {
        return user.getEnrollment().equals(enrollment);
    }

    public void updateCreateAt() {
        this.createdAt = LocalDateTime.now();
    }
}
