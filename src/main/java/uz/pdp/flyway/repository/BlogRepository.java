package uz.pdp.flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.flyway.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}