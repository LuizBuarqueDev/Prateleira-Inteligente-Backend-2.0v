package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.dto.BookDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Book;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BookMapper;
import br.com.lgbv.prateleira_inteligente_v2.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService extends GenericService<Book, BookDTO> {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    protected JpaRepository<Book, UUID> getJpaRepository() {
        return bookRepository;
    }

    @Override
    protected BaseMapper<Book, BookDTO> getMapper() {
        return bookMapper;
    }
}
