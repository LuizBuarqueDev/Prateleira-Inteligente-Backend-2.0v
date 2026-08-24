package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.config.security.JwtService;
import br.com.lgbv.prateleira_inteligente_v2.dto.LoginDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.RegisterDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.TokenResponse;
import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import br.com.lgbv.prateleira_inteligente_v2.enums.UserRole;
import br.com.lgbv.prateleira_inteligente_v2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterDTO request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        try {
            AppUser user = new AppUser();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole(UserRole.USER);
            user.setEnabled(true);
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar usuario");
        }
    }

    public TokenResponse login(LoginDTO request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = (org.springframework.security.core.userdetails.UserDetails) auth.getPrincipal();
        String token = jwtService.generateToken(user);

        return new TokenResponse(token);
    }

//    public void verifyEmail(String tokenValue) {
//
//        EmailVerificationToken token = emailVerificationService.validateToken(tokenValue);
//
//        AppUser user = token.getUser();
//        user.setEnabled(true);
//        userRepository.save(user);
//
//        emailVerificationService.deleteToken(token);
//    }
}