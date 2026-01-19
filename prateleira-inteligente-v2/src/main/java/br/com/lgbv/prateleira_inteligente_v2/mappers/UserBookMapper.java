package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserBookDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.BookSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.UserSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.UserBook;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserSimplifiedDTO.class, BookSimplifiedDTO.class})
public interface UserBookMapper extends BaseMapper<UserBook, UserBookDTO> {
    @Override
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserBook toEntity(UserBookDTO userBookDTO);

    @Override
    UserBookDTO toDto(UserBook entity);
}
