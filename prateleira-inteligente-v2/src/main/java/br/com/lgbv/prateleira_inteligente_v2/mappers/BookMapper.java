package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.dto.BookDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper extends BaseMapper<Book, BookDTO>{

    @Override
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "userBooks", ignore = true)
    Book toEntity(BookDTO bookDTO);

    @Override
    @Mapping(target = "authors", expression = "java(toIds(entity.getAuthors()))")
    @Mapping(target = "userBooks", expression = "java(toIds(entity.getUserBooks()))")
    BookDTO toDto(Book entity);
}
