package br.com.lgbv.prateleira_inteligente_v2.dto;

import br.com.lgbv.prateleira_inteligente_v2.enums.UserRole;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserDTO {
    private String name;
    private UserRole role;
    private Set<UUID> books;
    private Set<UUID> comments;
}
