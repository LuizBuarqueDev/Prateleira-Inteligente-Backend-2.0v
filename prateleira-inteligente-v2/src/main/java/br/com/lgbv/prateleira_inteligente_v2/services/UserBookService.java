package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.dto.UserBookDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.UserBook;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.UserBookMapper;
import br.com.lgbv.prateleira_inteligente_v2.repositories.UserBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserBookService extends GenericService<UserBook, UserBookDTO> {

    private final UserBookRepository userBookRepository;
    private final UserBookMapper userBookMapper;

    @Override
    protected JpaRepository<UserBook, UUID> getJpaRepository() {
        return userBookRepository;
    }

    @Override
    protected BaseMapper<UserBook, UserBookDTO> getMapper() {
        return userBookMapper;
    }
}
