package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper extends BaseMapper<AppUser, UserDTO> {

    @Mapping(target = "books", expression = "java(mapToIds(entity.getUserBooks()))")
    @Mapping(target = "comments", expression = "java(mapToIds(entity.getComments()))")
    UserDTO toDto(AppUser entity);

    @Mapping(target = "userBooks", expression = "java(mapToEntities(userDTO.getBooks(), id -> userBookRepository.findById(id).orElse(null)))")
    @Mapping(target = "comments", expression = "java(mapToEntities(userDTO.getComments(), id -> commentRepository.findById(id).orElse(null)))")
    AppUser toEntity(UserDTO userDTO);
}
