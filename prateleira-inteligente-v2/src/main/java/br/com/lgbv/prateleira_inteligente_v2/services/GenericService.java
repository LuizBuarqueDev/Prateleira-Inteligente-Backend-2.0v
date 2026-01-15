package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


public abstract class GenericService<E extends BaseEntity> implements IGenericService<E> {

    protected abstract JpaRepository<E, UUID> getJpaRepository();

    @Override
    @Transactional
    public E save(E entity) {
        beforeSave(entity);
        E saved = getJpaRepository().save(entity);
        afterSave(entity);
        return saved;
    }

    @Override
    @Transactional(readOnly = true)
    public E getById(UUID id) {
        return getJpaRepository().findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> getAll() {
        return getJpaRepository().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> getAllByIds(List<UUID> ids) {
        return getJpaRepository().findAllById(ids);
    }

    @Override
    @Transactional
    public E update(UUID id,E entity) {
        beforeUpdate(entity);
        E saved = getJpaRepository().save(entity);
        afterUpdate(entity);
        return saved;
    }

    @Override
    @Transactional
    public boolean deleteById(UUID id) {
        if (!getJpaRepository().existsById(id)) {
            return false;
        }
        getJpaRepository().deleteById(id);
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
