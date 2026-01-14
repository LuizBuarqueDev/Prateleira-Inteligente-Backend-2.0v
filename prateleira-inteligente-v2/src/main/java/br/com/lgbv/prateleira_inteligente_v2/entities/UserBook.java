package br.com.lgbv.prateleira_inteligente_v2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_books")
public class UserBook extends BaseEntity {

    private Integer rating;

    private Boolean OnTheSheff;
}
