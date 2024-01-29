package br.com.petshop.auth.infra.security;

import br.com.petshop.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEnrollment(Integer enrollment);
}
