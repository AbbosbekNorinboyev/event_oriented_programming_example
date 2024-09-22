package uz.pdp.flyway.service;

import uz.pdp.flyway.entity.Users;

public interface OtpService {
    void generateOtp(Users user);
}
