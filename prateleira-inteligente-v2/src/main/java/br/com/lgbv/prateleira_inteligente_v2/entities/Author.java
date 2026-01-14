package br.com.lgbv.prateleira_inteligente_v2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    private String name;

    private Set<Book> books;

}
