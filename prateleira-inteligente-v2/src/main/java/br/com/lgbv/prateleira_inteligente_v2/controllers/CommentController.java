package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.CommentDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
@Tag(
        name = "Comments",
        description = "Operations related to comments"
)
public class CommentController extends GenericController<CommentDTO, CommentService> {

    public CommentController(CommentService service) {
        super(service);
    }
}
