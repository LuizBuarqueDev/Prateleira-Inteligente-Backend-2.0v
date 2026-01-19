package br.com.lgbv.prateleira_inteligente_v2.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CategoriesDTO {
    private UUID id;
    private String name;
    private Set<UUID> books;
}
