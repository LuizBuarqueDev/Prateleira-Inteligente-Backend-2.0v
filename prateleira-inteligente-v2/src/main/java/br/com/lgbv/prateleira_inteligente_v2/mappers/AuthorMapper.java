package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.dto.AuthorDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends BaseMapper <Author, AuthorDTO> {

    @Override
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorDTO authorDTO);

    @Override
    @Mapping(target = "books", expression = "java(toIds(entity.getBooks()))")
    AuthorDTO toDto(Author entity);
}
