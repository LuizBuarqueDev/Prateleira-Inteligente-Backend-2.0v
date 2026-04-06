package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.dto.LoginDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.RegisterDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.TokenResponse;
import br.com.lgbv.prateleira_inteligente_v2.services.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(
        name = "Auth",
        description = "Operations related to authentication"
)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/regiter")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO registerDTO) {
        authService.register(registerDTO);
        return ResponseEntity.ok("Verify your email to activate your account");
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @GetMapping("/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        authService.verifyEmail(token);
        return ResponseEntity.ok("Email verified successfully");
    }
}

