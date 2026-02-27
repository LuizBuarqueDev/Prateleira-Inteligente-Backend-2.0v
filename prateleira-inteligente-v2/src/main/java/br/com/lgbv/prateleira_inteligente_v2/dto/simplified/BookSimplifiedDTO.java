package br.com.lgbv.prateleira_inteligente_v2.dto.simplified;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class BookSimplifiedDTO {
    private UUID id;
    private String title;
    private String publisher;
    private byte[] cover;
    private Double score;
    private Long assessmentQuantity;
    private Set<String> categoriesNames;
}