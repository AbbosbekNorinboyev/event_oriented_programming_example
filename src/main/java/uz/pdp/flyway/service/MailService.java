package uz.pdp.flyway.service;

import java.util.Map;

public interface MailService {
    void sendVerificationModel(Map<Object, Object> model);

    boolean turnOnOffSMPTServer();
    boolean isSMTPActive();
}
