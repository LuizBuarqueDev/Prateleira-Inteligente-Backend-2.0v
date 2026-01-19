package br.com.lgbv.prateleira_inteligente_v2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<Categories> categories = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<UserBook> userBooks = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Comment> comments =  new HashSet<>();
}
