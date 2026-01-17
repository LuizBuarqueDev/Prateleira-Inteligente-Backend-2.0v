package br.com.lgbv.prateleira_inteligente_v2.dto;

import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.UserSimplified;
import lombok.Data;

import java.util.UUID;

@Data
public class UserBookDTO {
    private UUID id;
    private Integer rating;
    private UUID bookId;
    private UserSimplified user;
}
