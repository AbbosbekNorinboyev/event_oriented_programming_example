package uz.pdp.flyway.events;

import lombok.Getter;
import org.apache.catalina.User;
import org.springframework.context.ApplicationEvent;
import uz.pdp.flyway.entity.Users;

@Getter
public final class UserUpdatedEventHandler extends ApplicationEvent {
    private final Users user;
    public UserUpdatedEventHandler(Object source, Users user) {
        super(source);
        this.user = user;
    }
}
