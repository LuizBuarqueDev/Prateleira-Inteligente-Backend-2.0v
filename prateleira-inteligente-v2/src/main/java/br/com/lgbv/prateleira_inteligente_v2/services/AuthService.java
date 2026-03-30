package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.config.security.JwtService;
import br.com.lgbv.prateleira_inteligente_v2.dto.LoginDTO;
import br.com.lgbv.prateleira_inteligente_v2.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public TokenResponse authenticate(LoginDTO request) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(user);

        return new TokenResponse(token);
    }
}