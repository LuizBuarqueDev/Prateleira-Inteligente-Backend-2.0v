package br.com.lgbv.prateleira_inteligente_v2.repositories;

import br.com.lgbv.prateleira_inteligente_v2.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query("""
                SELECT DISTINCT b FROM Book b
                LEFT JOIN b.authors a
                LEFT JOIN b.categories c
                WHERE (:term IS NULL OR :term = '' OR
                     LOWER(b.title) LIKE LOWER(CONCAT('%', :term, '%')) OR
                     LOWER(a.name) LIKE LOWER(CONCAT('%', :term, '%')) OR
                     LOWER(c.name) LIKE LOWER(CONCAT('%', :term, '%'))
                    )
            """)
    Page<Book> search(@Param("term") String term, Pageable pageable);
}
