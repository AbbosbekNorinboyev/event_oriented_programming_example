package uz.pdp.flyway.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import uz.pdp.flyway.entity.Blog;

@Getter
public final class BlogDeletedEventHandler extends ApplicationEvent {
    private final Blog blog;
    public BlogDeletedEventHandler(Object source, Blog blog) {
        super(source);
        this.blog = blog;
    }
}
