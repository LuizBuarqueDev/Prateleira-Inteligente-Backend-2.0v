package br.com.lgbv.prateleira_inteligente_v2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(nullable = false)
    private String title;

    private byte[] cover;

    private LocalDate publicationDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String publisher;

    private Double score;

    private Long assessmentQuantity;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

    @ManyToMany(mappedBy = "books")
    private Set<Categories> categories;

    @OneToMany(mappedBy = "books")
    private Set<UserBook> userBooks;

    @OneToMany(mappedBy = "books")
    private Set<Comment> comments;
}
