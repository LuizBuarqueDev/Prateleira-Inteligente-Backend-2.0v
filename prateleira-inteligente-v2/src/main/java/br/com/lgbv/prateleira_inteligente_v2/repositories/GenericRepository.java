package br.com.lgbv.prateleira_inteligente_v2.repositories;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;
@NoRepositoryBean
public interface GenericRepository <E extends BaseEntity> extends JpaRepository<E, UUID> { }
