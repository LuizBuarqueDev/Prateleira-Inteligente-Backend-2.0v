package br.com.lgbv.prateleira_inteligente_v2.repositories;

import br.com.lgbv.prateleira_inteligente_v2.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, UUID> {
}
