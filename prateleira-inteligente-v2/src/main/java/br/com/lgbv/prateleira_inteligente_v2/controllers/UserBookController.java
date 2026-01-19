package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserBookDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.IGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-books")
public class UserBookController extends GenericController<UserBookDTO> {

    public UserBookController(IGenericService<UserBookDTO> service) {
        super(service);
    }
}