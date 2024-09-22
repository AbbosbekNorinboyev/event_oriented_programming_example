package uz.pdp.flyway.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uz.pdp.flyway.entity.Users;

@Getter
@RequiredArgsConstructor
public final class OtpGenerateEvent {
    private final Users users;
}
