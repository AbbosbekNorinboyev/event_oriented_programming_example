package uz.pdp.flyway.service;

import uz.pdp.flyway.dto.BlogCreateDTO;
import uz.pdp.flyway.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog createBlog(BlogCreateDTO blogCreateDTO);
    Blog getBlog(Integer id);
    List<Blog> getBlogAll();
    void updateBlog(Blog blog);
    void deleteBlog(Integer id);
}
