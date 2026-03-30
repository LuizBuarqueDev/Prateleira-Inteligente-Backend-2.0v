package br.com.lgbv.prateleira_inteligente_v2.repositories;

import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <AppUser, UUID> {
    Optional<AppUser> findByUsername(String username);
}
