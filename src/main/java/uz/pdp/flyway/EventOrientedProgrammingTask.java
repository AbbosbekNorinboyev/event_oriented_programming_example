package uz.pdp.flyway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import uz.pdp.flyway.service.CacheService;
import uz.pdp.flyway.service.MailService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class EventOrientedProgrammingTask {
    private final CacheService cacheService;
    private final MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(EventOrientedProgrammingTask.class, args);
    }

    @Scheduled(initialDelay = 5, fixedDelay = 60, timeUnit = TimeUnit.SECONDS)
    public void sendCachedVerificationMails() {
        if (mailService.isSMTPActive()) {
            ConcurrentHashMap<Object, Map<Object, Object>> cache = cacheService.getCache();
            cache.forEach((key, value) -> {
                mailService.sendVerificationModel(value);
                cache.remove(key);
            });
        } else {
            log.info("SMTP server is off");
        }
    }
}
