package br.com.lgbv.prateleira_inteligente_v2.dto;

import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.UserSimplifiedDTO;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class CommentDTO {
    private UUID id;
    private String text;
    private Instant createdAt;
    private UUID bookId;
    private UserSimplifiedDTO user;
}
