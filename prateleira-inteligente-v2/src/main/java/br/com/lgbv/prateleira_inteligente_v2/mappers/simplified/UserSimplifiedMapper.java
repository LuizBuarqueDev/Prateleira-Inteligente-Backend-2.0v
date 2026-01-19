package br.com.lgbv.prateleira_inteligente_v2.mappers.simplified;

import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.UserSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSimplifiedMapper {
    UserSimplifiedDTO toDTO(AppUser user);
}
