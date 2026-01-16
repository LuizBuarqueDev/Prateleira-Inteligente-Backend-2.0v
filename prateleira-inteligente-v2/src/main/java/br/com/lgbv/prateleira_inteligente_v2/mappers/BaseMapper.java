package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public interface BaseMapper<E,DTO> {

    E toEntity(DTO dto);

    DTO toDto(E entity);

    default Set<UUID> toIds(Set<? extends BaseEntity> entities) {
        if (entities == null) return null;

        return entities.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
    }
}
