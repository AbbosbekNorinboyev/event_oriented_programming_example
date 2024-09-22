package uz.pdp.flyway.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import uz.pdp.flyway.entity.Users;
import uz.pdp.flyway.events.OtpGenerateEvent;
import uz.pdp.flyway.events.SendMailEvent;
import uz.pdp.flyway.repository.UsersRepository;
import uz.pdp.flyway.service.MailServiceImpl;
import uz.pdp.flyway.service.OtpService;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class UsersEventsListener {
    private final OtpService otpService;
    private final MailServiceImpl mailService;

    @EventListener
    public CompletableFuture<SendMailEvent> generateOtpEventListener(OtpGenerateEvent event) throws InterruptedException {
        Users user = event.getUsers();
        otpService.generateOtp(user);
        log.info("Generate Otp: " + user);
        return CompletableFuture.completedFuture(new SendMailEvent(user.getId(), user.getName(), user.getOtp()));
    }
    @EventListener()
    public void verificationMailSenderListener(SendMailEvent event) {
        Map<Object, Object> model = Map.of(
                "userId", event.getId(),
                "name", event.getName(),
                "otp", event.getOtp()
        );
        mailService.sendVerificationModel(model);
    }
}
