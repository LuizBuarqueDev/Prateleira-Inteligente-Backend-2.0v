package br.com.lgbv.prateleira_inteligente_v2.mappers.simplified;

import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.BookSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookSimplifiedMapper {
    BookSimplifiedDTO toDTO(Book book);
}
