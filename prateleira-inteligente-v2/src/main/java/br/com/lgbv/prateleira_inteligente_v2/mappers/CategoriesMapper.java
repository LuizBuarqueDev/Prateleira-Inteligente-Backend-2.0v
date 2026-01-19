package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.dto.CategoriesDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriesMapper extends BaseMapper <Categories, CategoriesDTO> {
    @Override
    @Mapping(target = "books", ignore = true)
    Categories toEntity(CategoriesDTO categoriesDTO);

    @Override
    @Mapping(target = "books", expression = "java(toIds(entity.getBooks()))")
    CategoriesDTO toDto(Categories entity);
}
