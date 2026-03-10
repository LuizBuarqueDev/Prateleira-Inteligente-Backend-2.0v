package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserBookDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.UserBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-books")
@Tag(name = "UserBooks", description = "Operations related to user books")
public class UserBookController extends GenericController<UserBookDTO, UserBookService> {

    public UserBookController(UserBookService service) {
        super(service);
    }

    @RequestMapping("/user-id")
    @Operation(summary = "Get all books by user id")
    public ResponseEntity<List<UserBookDTO>> getByUserId(UUID userId){
        return ResponseEntity.ok(service.getByUserId(userId)) ;
    }
}