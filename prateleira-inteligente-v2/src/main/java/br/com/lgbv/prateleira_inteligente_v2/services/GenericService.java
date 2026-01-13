package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class GenericService<E extends BaseEntity> implements IGenericService<E> {

    protected final JpaRepository<E, UUID> repository;

    @Override
    public E save(E entity) {
        beforeSave(entity);
        E saved = repository.save(entity);
        afterSave(entity);
        return saved;
    }

    @Override
    public E getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }

    @Override
    public List<E> getAllByIds(List<UUID> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public E update(UUID id,E entity) {
        beforeUpdate(entity);
        E saved = repository.save(entity);
        afterUpdate(entity);
        return saved;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    protected void beforeSave(E entity) {

    }

    protected void afterSave(E entity) {

    }

    protected void beforeUpdate(E entity) {

    }

    protected void afterUpdate(E entity) {

    }
}
