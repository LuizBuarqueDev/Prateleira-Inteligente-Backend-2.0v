package br.com.lgbv.prateleira_inteligente_v2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    private String title;

    private byte[] cover;

    private LocalDate publicationDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String publisher;

    private Double score;

    private Long assessmentQuantity;
}
