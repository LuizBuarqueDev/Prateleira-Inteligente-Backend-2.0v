package br.com.lgbv.prateleira_inteligente_v2.mappers.simplified;

import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.BookSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Book;
import br.com.lgbv.prateleira_inteligente_v2.mappers.CategoriesMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoriesMapper.class})
public interface BookSimplifiedMapper {

    @Mapping(target = "categoriesNames", source = "categories")
    BookSimplifiedDTO toDTO(Book book);
}
