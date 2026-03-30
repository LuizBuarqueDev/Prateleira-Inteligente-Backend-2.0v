package br.com.lgbv.prateleira_inteligente_v2.config.security;

import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import br.com.lgbv.prateleira_inteligente_v2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username.replace(" ", "")));

        return new AppUserDetails(user);
    }
}