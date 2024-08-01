package br.com.petshop.auth.infra;

import br.com.petshop.auth.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepositoy extends JpaRepository<Token, String> {

    Token findByRefresh(String refresh);
}
