package br.com.lgbv.prateleira_inteligente_v2.entities;

import br.com.lgbv.prateleira_inteligente_v2.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "app_users")
public class AppUser extends BaseEntity {

    private String username;

    private UserRole role;
}
