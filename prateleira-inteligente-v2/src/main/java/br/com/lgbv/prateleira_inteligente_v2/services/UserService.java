package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.UserMapper;
import br.com.lgbv.prateleira_inteligente_v2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService extends GenericService<AppUser, UserDTO> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    protected JpaRepository<AppUser, UUID> getJpaRepository() {
        return userRepository;
    }

    @Override
    protected BaseMapper<AppUser, UserDTO> getMapper() {
        return userMapper;
    }
}
