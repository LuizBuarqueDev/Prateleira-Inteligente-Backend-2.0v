package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserDTO;
import br.com.lgbv.prateleira_inteligente_v2.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(
        name = "Users",
        description = "Operations related to system users"
)
public class UserController extends GenericController<UserDTO, UserService> {

    public UserController(UserService service) {
        super(service);
    }
}