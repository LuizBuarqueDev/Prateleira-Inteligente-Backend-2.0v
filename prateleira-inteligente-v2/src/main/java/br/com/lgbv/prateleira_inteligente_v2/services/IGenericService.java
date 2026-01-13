package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface IGenericService <E extends BaseEntity> {

    E save(E entity);

    E getById(UUID id);

    List<E> getAll();

    List<E> getAllByIds(List<UUID> ids);

    E update(UUID id,E entity);

    boolean deleteById(UUID id);
}
