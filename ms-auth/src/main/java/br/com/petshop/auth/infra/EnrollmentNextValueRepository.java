package br.com.petshop.auth.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EnrollmentNextValueRepository {

    private final EntityManager entityManager;

    public Integer next() {
        Query query = entityManager.createNativeQuery("SELECT nextval('seq_user_enrollment')");
        Long value = (Long) query.getSingleResult();
        return value.intValue();
    }
}
