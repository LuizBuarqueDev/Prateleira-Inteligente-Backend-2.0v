package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.dto.AuthorDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Author;
import br.com.lgbv.prateleira_inteligente_v2.mappers.AuthorMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService extends GenericService <Author, AuthorDTO> {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    protected JpaRepository<Author, UUID> getJpaRepository() {
        return authorRepository;
    }

    @Override
    protected BaseMapper<Author, AuthorDTO> getMapper() {
        return authorMapper;
    }
}
