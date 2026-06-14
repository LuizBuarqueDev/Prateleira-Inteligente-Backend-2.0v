package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.BookDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.simplified.BookSimplifiedDTO;
import br.com.lgbv.prateleira_inteligente_v2.enums.BookSortField;
import br.com.lgbv.prateleira_inteligente_v2.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Books", description = "Operations related to books")
public class BookController
        extends GenericController<BookDTO, BookService> {

    public BookController(BookService service) {
        super(service);
    }

    @GetMapping("/simplified")
    @Operation(summary = "Get all Simplified books")
    public ResponseEntity<List<BookSimplifiedDTO>> getAllSimplifiedBooks() {
        return ResponseEntity.ok(service.geAllSimplifiedBook());
    }

    @GetMapping("/search")
    @Operation(summary = "Search books by term")
    public ResponseEntity<Page<BookSimplifiedDTO>> search(
            @RequestParam String term,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(service.search(term, page, size));
    }

    @GetMapping("/page")
    @Operation(summary = "Get all books with pagination, sorted by parameters.")
    public ResponseEntity<Page<BookSimplifiedDTO>> getAllSortedByParams(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "TITLE") BookSortField sortBy,
            @RequestParam(defaultValue = "true") boolean direction
    ) {
        return ResponseEntity.ok(service.getAllSortedByParams(page,size,sortBy,direction));
    }
}