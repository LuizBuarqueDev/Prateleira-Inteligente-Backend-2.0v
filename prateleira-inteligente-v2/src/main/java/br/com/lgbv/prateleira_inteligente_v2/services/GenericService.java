package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class GenericService<E extends BaseEntity> implements IGenericService<E> {

    protected final JpaRepository<E, UUID> repository;

    @Override
    @Transactional
    public E save(E entity) {
        beforeSave(entity);
        E saved = repository.save(entity);
        afterSave(entity);
        return saved;
    }

    @Override
    @Transactional(readOnly = true)
    public E getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> getAllByIds(List<UUID> ids) {
        return repository.findAllById(ids);
    }

    @Override
    @Transactional
    public E update(UUID id,E entity) {
        beforeUpdate(entity);
        E saved = repository.save(entity);
        afterUpdate(entity);
        return saved;
    }

    @Override
    @Transactional
    public boolean deleteById(UUID id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
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
