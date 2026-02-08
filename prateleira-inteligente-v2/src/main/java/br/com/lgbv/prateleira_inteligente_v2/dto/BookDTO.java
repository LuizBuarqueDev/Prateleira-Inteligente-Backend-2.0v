package br.com.lgbv.prateleira_inteligente_v2.dto;

import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.AuthorSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.CategoriesSimplifiedDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
public class BookDTO {
    private UUID id;
    private String title;
    private byte[] cover;
    private LocalDate publicationDate;
    private String description;
    private String publisher;
    private Double score;
    private Long assessmentQuantity;
    private Set<AuthorSimplifiedDTO> authors;
    private Set<CategoriesSimplifiedDTO> categories;
    private Set<UUID> userBooks;
}
