package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.BookDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@Tag(
        name = "Books",
        description = "Operations related to books"
)
public class BookController extends GenericController<BookDTO>{

    public BookController(BookService service) {
        super(service);
    }
}
