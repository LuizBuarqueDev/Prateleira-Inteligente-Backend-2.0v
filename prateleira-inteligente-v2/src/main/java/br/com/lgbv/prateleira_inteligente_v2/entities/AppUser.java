package br.com.lgbv.prateleira_inteligente_v2.entities;

import br.com.lgbv.prateleira_inteligente_v2.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "app_users")
public class AppUser extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    private String password;
}
