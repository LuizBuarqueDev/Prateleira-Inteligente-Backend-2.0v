package br.com.lgbv.prateleira_inteligente_v2.dto;

import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.BookSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.UserSimplifiedDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class UserBookDTO {
    private UUID id;
    private Integer rating;
    private BookSimplifiedDTO book;
    private UserSimplifiedDTO user;
}
