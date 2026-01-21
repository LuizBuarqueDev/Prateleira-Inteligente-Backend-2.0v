package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.CategoriesDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.CategoriesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@Tag(
        name = "Categories",
        description = "Operations related to categories"
)
public class CategoriesController extends GenericController<CategoriesDTO, CategoriesService> {

    public CategoriesController(CategoriesService service) {
        super(service);
    }
}
