package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.UserMapper;
import br.com.lgbv.prateleira_inteligente_v2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService extends GenericService<AppUser, UserDTO> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected JpaRepository<AppUser, UUID> getJpaRepository() {
        return userRepository;
    }

    @Override
    protected BaseMapper<AppUser, UserDTO> getMapper() {
        return userMapper;
    }

    @Override
    protected void beforeSave(AppUser entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
    }

    @Override
    protected void beforeUpdate(AppUser entity) {
        if (entity.getPassword() != null && !entity.getPassword().startsWith("$2a$")) {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        }
    }
}