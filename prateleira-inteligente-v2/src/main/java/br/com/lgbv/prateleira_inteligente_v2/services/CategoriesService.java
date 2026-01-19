package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.dto.CategoriesDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Categories;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.CategoriesMapper;
import br.com.lgbv.prateleira_inteligente_v2.repositories.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriesService extends GenericService<Categories, CategoriesDTO> {

    private final CategoriesRepository categoriesRepository;
    private final CategoriesMapper categoriesMapper;

    @Override
    protected JpaRepository<Categories, UUID> getJpaRepository() {
        return categoriesRepository;
    }

    @Override
    protected BaseMapper<Categories, CategoriesDTO> getMapper() {
        return categoriesMapper;
    }
}
