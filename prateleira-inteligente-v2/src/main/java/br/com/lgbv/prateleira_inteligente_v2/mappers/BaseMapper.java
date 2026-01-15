package br.com.lgbv.prateleira_inteligente_v2.mappers;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;

import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface BaseMapper<E,DTO> {

    E toEntity(DTO dto);

    DTO toDto(E entity);

    default Set<UUID> mapToIds(Set<? extends BaseEntity> entities) {
        return entities.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
    }

    default <T extends BaseEntity> Set<T> mapToEntities(Set<UUID> ids, Function<UUID, T> fetcher) {
        return ids.stream()
                .map(fetcher)
                .collect(Collectors.toSet());
    }
}
