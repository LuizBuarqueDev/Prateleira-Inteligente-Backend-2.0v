package br.com.lgbv.prateleira_inteligente_v2.repositories;

import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository <AppUser, UUID> {
}
