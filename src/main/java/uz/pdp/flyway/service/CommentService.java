package uz.pdp.flyway.service;

import uz.pdp.flyway.dto.CommentCreateDTO;
import uz.pdp.flyway.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(CommentCreateDTO commentCreateDTO);
    Comment getComment(Integer id);
    List<Comment> getCommentAll();
    void updateComment(Comment comment);
    void deleteComment(Integer id);
}
