package br.com.lgbv.prateleira_inteligente_v2.services;

import br.com.lgbv.prateleira_inteligente_v2.dto.CommentDTO;
import br.com.lgbv.prateleira_inteligente_v2.entities.Comment;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.mappers.CommentMapper;
import br.com.lgbv.prateleira_inteligente_v2.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService extends GenericService <Comment, CommentDTO>{

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    protected JpaRepository<Comment, UUID> getJpaRepository() {
        return commentRepository;
    }

    @Override
    protected BaseMapper<Comment, CommentDTO> getMapper() {
        return commentMapper;
    }
}
