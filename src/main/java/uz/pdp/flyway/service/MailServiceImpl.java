package uz.pdp.flyway.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final CacheService cacheService;
    private boolean on = false;
    @Override
    public void sendVerificationModel(Map<Object, Object> model) {
        if (on) {
            log.info("Connecting to SMTP server");
            log.info("Sending Mail: {}", model);
        } else {
            log.info("Caching Mail model: {}", model);
            cacheService.put(model);
        }
    }

    @Override
    public boolean turnOnOffSMPTServer() {
        return this.on = !on;
    }

    @Override
    public boolean isSMTPActive() {
        return on;
    }
}
