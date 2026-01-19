package br.com.lgbv.prateleira_inteligente_v2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name= "authors_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id")
    )
    private Set<Book> books = new HashSet<>();

}
