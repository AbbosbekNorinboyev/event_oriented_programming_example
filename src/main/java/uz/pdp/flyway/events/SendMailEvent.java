package uz.pdp.flyway.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public final class SendMailEvent {
    private final Integer id;
    private final String name;
    private final String otp;
}
