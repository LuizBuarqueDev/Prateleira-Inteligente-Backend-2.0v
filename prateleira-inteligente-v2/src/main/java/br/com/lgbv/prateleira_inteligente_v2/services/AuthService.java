package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.config.security.JwtService;
import br.com.lgbv.prateleira_inteligente_v2.dto.LoginDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.RegisterDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.TokenResponse;
import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import br.com.lgbv.prateleira_inteligente_v2.entities.EmailVerificationToken;
import br.com.lgbv.prateleira_inteligente_v2.enums.UserRole;
import br.com.lgbv.prateleira_inteligente_v2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailVerificationService emailVerificationService;
    private final EmailService emailService;

    public void register(RegisterDTO request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(UserRole.USER);
        user.setEnabled(false);

        AppUser savedUser = userRepository.save(user);

        EmailVerificationToken token = emailVerificationService.createToken(savedUser);

        String link = "http://localhost:8080/auth/verify-email?token=" + token.getToken();

        emailService.sendVerificationEmail(savedUser.getEmail(), link);
    }

    public TokenResponse login(LoginDTO request) {
        try {
            var auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            var user = (org.springframework.security.core.userdetails.UserDetails) auth.getPrincipal();
            String token = jwtService.generateToken(user);

            return new TokenResponse(token);

        } catch (DisabledException ex) {
            throw new IllegalArgumentException("Verifique seu email antes de logar");
        }
    }

    public void verifyEmail(String tokenValue) {

        EmailVerificationToken token = emailVerificationService.validateToken(tokenValue);

        AppUser user = token.getUser();
        user.setEnabled(true);
        userRepository.save(user);

        emailVerificationService.deleteToken(token);
    }
}