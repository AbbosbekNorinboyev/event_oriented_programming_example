package uz.pdp.flyway.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import uz.pdp.flyway.entity.Blog;

@Getter
public final class BlogDeletedEvent extends ApplicationEvent {
    private final Blog blog;
    public BlogDeletedEvent(Object source, Blog blog) {
        super(source);
        this.blog = blog;
    }
}
