package uz.pdp.flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.flyway.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}