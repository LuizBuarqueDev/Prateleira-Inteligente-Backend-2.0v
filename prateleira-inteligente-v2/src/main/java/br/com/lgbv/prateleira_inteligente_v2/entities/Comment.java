package br.com.lgbv.prateleira_inteligente_v2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column(length = 1000)
    private String text;

    private Instant createdAt;
}
