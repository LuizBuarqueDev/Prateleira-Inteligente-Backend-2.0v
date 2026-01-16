package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends GenericController<UserDTO> {

    public UserController(UserService service) {
        super(service);
    }
}
