package uz.pdp.flyway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.flyway.dto.CommentCreateDTO;
import uz.pdp.flyway.entity.Comment;
import uz.pdp.flyway.repository.CommentRepository;
import uz.pdp.flyway.service.CommentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody CommentCreateDTO commentCreateDTO) {
        return ResponseEntity.status(201).body(commentService.createComment(commentCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Integer id) {
        return ResponseEntity.ok(commentService.getComment(id));
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getCommentAll() {
        return ResponseEntity.ok(commentService.getCommentAll());
    }

    @PutMapping
    public ResponseEntity<Void> updateComment(@RequestBody Comment updateComment) {
        Comment comment = commentRepository.findById(updateComment.getId())
                .orElseThrow(() -> new RuntimeException("Comment not found: " + updateComment.getId()));
        if (updateComment.getAuthor() != null) {
            comment.setAuthor(updateComment.getAuthor());
        }
        if (updateComment.getMessage() != null) {
            comment.setMessage(updateComment.getMessage());
        }
        commentService.updateComment(comment);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
