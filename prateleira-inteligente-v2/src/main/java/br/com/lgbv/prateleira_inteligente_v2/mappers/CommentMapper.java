package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.dto.CommentDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.UserSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserSimplifiedDTO.class})
public interface CommentMapper extends BaseMapper<Comment, CommentDTO> {
    @Override
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    Comment toEntity(CommentDTO commentDTO);

    @Override
    @Mapping(target = "bookId", expression = "java(entity.getBook().getId())")
    CommentDTO toDto(Comment entity);
}
