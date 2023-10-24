package br.com.petshop.auth.infra.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, String> {

    UserAuthentication findByEnrollment(String enrollment);
}
