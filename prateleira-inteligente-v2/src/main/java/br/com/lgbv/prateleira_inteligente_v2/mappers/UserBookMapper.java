package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserBookDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.UserBook;
import br.com.lgbv.prateleira_inteligente_v2.mappers.simplified.BookSimplifiedMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserBookMapper.class, BookSimplifiedMapper.class})
public interface UserBookMapper extends BaseMapper<UserBook, UserBookDTO> {
    @Override
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserBook toEntity(UserBookDTO userBookDTO);

    @Override
    UserBookDTO toDto(UserBook entity);
}
