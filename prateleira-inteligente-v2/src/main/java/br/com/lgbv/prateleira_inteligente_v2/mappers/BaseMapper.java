package br.com.lgbv.prateleira_inteligente_v2.mappers;

public interface BaseMapper<E,DTO> {

    E toEntity(DTO dto);

    DTO toDto(E entity);

}
