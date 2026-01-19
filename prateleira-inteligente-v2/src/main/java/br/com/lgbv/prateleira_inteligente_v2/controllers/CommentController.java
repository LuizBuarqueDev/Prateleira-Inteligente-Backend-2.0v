package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.CommentDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.IGenericService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@Tag(
        name = "Comments",
        description = "Operations related to comments"
)
public class CommentController extends GenericController<CommentDTO> {

    public CommentController(IGenericService<CommentDTO> service) {
        super(service);
    }
}
