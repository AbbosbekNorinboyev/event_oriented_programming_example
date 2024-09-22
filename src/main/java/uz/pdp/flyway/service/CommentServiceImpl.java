package uz.pdp.flyway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.flyway.dto.CommentCreateDTO;
import uz.pdp.flyway.entity.Comment;
import uz.pdp.flyway.mapper.CommentMapper;
import uz.pdp.flyway.repository.BlogRepository;
import uz.pdp.flyway.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    @Override
    public Comment createComment(CommentCreateDTO commentCreateDTO) {
        Comment comment = commentMapper.toEntity(commentCreateDTO);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment getComment(Integer id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found: " + id));
    }

    @Override
    public List<Comment> getCommentAll() {
        return commentRepository.findAll();
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
