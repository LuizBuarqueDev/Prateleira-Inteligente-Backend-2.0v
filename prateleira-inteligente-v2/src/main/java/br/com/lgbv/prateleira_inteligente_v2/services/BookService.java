package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.dto.BookDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.BookSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Book;
import br.com.lgbv.prateleira_inteligente_v2.enums.BookSortField;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BookMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.simplified.BookSimplifiedMapper;
import br.com.lgbv.prateleira_inteligente_v2.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService extends GenericService<Book, BookDTO> {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private final BookSimplifiedMapper bookSimplifiedMapper;

    @Override
    protected JpaRepository<Book, UUID> getJpaRepository() {
        return bookRepository;
    }

    @Override
    protected BaseMapper<Book, BookDTO> getMapper() {
        return bookMapper;
    }

    public List<BookSimplifiedDTO> geAllSimplifiedBook() {
        return bookRepository.findAll()
                .stream()
                .map(bookSimplifiedMapper::toDTO)
                .toList();
    }

    public Page<BookSimplifiedDTO> search(String term, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title"));
        return bookRepository
                .search(term, pageable)
                .map(bookSimplifiedMapper::toDTO);
    }

    public Page<BookSimplifiedDTO> getAllSortedByParams (
            int page,
            int size,
            BookSortField sortBy,
            boolean ascending
    ) {
        String field = switch (sortBy) {
            case TITLE -> "title";
            case SCORE -> "score";
            case PUBLICATION_DATE -> "publicationDate";
            case ASSESSMENT_QUANTITY -> "assessmentQuantity";
        };
        Sort sort = ascending
                ? Sort.by(field).ascending()
                : Sort.by(field).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return bookRepository
                .findAll(pageable)
                .map(bookSimplifiedMapper::toDTO);
    }
}