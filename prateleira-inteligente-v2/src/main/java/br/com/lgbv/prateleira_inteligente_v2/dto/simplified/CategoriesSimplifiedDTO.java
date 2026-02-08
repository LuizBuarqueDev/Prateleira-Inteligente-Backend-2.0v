package br.com.lgbv.prateleira_inteligente_v2.dto.simplified;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoriesSimplifiedDTO {
    private UUID id;
    private String name;
}