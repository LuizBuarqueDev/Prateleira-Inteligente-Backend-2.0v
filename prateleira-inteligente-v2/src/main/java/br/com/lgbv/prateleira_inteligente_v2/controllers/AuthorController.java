package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.AuthorDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@Tag(
        name = "Authors",
        description = "Operations related to system authors"
)
public class AuthorController extends GenericController<AuthorDTO, AuthorService> {

    public AuthorController(AuthorService service) {
        super(service);
    }
}
