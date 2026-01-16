package br.com.lgbv.prateleira_inteligente_v2.dto;

import br.com.lgbv.prateleira_inteligente_v2.enums.UserRole;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserDTO {
    private String username;
    private UserRole role;
    private String password;
    private Set<UUID> userBooks;
    private Set<UUID> comments;
}
