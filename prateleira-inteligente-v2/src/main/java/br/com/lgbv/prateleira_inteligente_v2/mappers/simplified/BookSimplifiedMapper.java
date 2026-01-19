package br.com.lgbv.prateleira_inteligente_v2.mappers.simplified;


import br.com.lgbv.prateleira_inteligente_v2.dto.BookDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.BookSimplifiedDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookSimplifiedMapper {
    BookSimplifiedDTO toDTO(BookDTO user);
}
