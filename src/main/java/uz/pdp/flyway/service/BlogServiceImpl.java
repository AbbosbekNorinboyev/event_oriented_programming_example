package uz.pdp.flyway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.flyway.dto.BlogCreateDTO;
import uz.pdp.flyway.dto.CommentCreateDTO;
import uz.pdp.flyway.entity.Blog;
import uz.pdp.flyway.entity.Comment;
import uz.pdp.flyway.mapper.BlogMapper;
import uz.pdp.flyway.mapper.CommentMapperImpl;
import uz.pdp.flyway.repository.BlogRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogMapper blogMapper;
    private final BlogRepository blogRepository;

    @Override
    public Blog createBlog(BlogCreateDTO blogCreateDTO) {
        Blog blog = blogMapper.toEntity(blogCreateDTO);
        blogRepository.save(blog);
        return blog;
    }

    @Override
    public Blog getBlog(Integer id) {
        return blogRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Blog not found: " + id));
    }

    @Override
    public List<Blog> getBlogAll() {
        return blogRepository.findAll();
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }
}
