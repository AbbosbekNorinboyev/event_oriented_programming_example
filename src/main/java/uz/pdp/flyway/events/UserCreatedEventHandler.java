package uz.pdp.flyway.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import uz.pdp.flyway.entity.Users;
@Getter
public final class UserCreatedEventHandler extends ApplicationEvent {
    private final Users user;
    public UserCreatedEventHandler(Object source, Users user) {
        super(source);
        this.user = user;
    }
}
