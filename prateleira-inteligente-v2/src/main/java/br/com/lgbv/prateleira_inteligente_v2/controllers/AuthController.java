package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.LoginDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.TokenResponse;
import br.com.lgbv.prateleira_inteligente_v2.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginDTO request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}

