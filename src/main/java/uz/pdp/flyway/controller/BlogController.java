package uz.pdp.flyway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.flyway.dto.BlogCreateDTO;
import uz.pdp.flyway.entity.Blog;
import uz.pdp.flyway.repository.BlogRepository;
import uz.pdp.flyway.service.BlogService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @PostMapping("/create")
    public ResponseEntity<Blog> createBlog(@RequestBody BlogCreateDTO blogCreateDTO) {
        return ResponseEntity.status(201).body(blogService.createBlog(blogCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.getBlog(id));
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogAll() {
        return ResponseEntity.ok(blogService.getBlogAll());
    }

    @PutMapping
    public ResponseEntity<Void> updateBlog(@RequestBody Blog updatingBlog) {
        Blog blog = blogRepository.findById(updatingBlog.getId())
                .orElseThrow(() -> new RuntimeException("Blog not found: " + updatingBlog.getId()));
        if (updatingBlog.getDescription() != null) {
            blog.setDescription(updatingBlog.getDescription());
        }
        if (updatingBlog.getTitle() != null) {
            blog.setTitle(updatingBlog.getTitle());
        }
        if (updatingBlog.getComments() != null) {
            blog.setComments(updatingBlog.getComments());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
}
