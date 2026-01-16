package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
public abstract class GenericService<
        E extends BaseEntity,
        DTO
        > implements IGenericService<DTO> {

    protected abstract JpaRepository<E, UUID> getJpaRepository();

    protected abstract BaseMapper<E, DTO> getMapper();

    @Override
    public DTO save(DTO dto) {
        E entity = getMapper().toEntity(dto);
        beforeSave(entity);
        E saved = getJpaRepository().save(entity);
        afterSave(saved);
        return getMapper().toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public DTO getById(UUID id) {
        return getMapper().toDto(
                getJpaRepository().findById(id)
                        .orElseThrow(() -> new RuntimeException("Entity not found"))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> getAll() {
        return getJpaRepository().findAll()
                .stream()
                .map(getMapper()::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> getAllByIds(List<UUID> ids) {
        return getJpaRepository().findAllById(ids)
                .stream()
                .map(getMapper()::toDto)
                .toList();
    }

    @Override
    public DTO update(UUID id, DTO dto) {
        E entity = getMapper().toEntity(dto);
        beforeUpdate(entity);
        E saved = getJpaRepository().save(entity);
        afterUpdate(saved);
        return getMapper().toDto(saved);
    }

    @Override
    public boolean deleteById(UUID id) {
        if (!getJpaRepository().existsById(id)) {
            return false;
        }
        getJpaRepository().deleteById(id);
        return true;
    }

    protected void beforeSave(E entity) {}

    protected void afterSave(E entity) {}

    protected void beforeUpdate(E entity) {}

    protected void afterUpdate(E entity) {}
}

