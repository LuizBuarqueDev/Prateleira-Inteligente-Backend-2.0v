package br.com.lgbv.prateleira_inteligente_v2.services;

import java.util.List;
import java.util.UUID;

public interface IGenericService<DTO> {

    DTO save(DTO dto);

    DTO getById(UUID id);

    List<DTO> getAll();

    List<DTO> getAllByIds(List<UUID> ids);

    DTO update(UUID id, DTO dto);

    boolean deleteById(UUID id);
}
