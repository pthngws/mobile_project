package com.web_mobile.service.impl;

import com.web_mobile.entity.OtpVerificationEntity;
import com.web_mobile.repository.OtpVerificationRepository;
import com.web_mobile.service.OtpService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private OtpVerificationRepository otpRepository;
    @Override
    public String generateOtp(String email) {
        String otp = String.valueOf(new Random().nextInt(999999)); // Generate a random 6-digit OTP
        OtpVerificationEntity otpVerification = otpRepository.findByEmail(email)
                .orElse(new OtpVerificationEntity());
        otpVerification.setEmail(email);
        otpVerification.setOtp(otp);
        otpVerification.setCreatedAt(LocalDateTime.now());
        otpRepository.save(otpVerification);
        return otp;
    }

    @Override
    public boolean validateOtp(String email, String otp) {
        return otpRepository.findByEmail(email)
                .filter(o -> o.getOtp().equals(otp) &&
                        o.getCreatedAt().isAfter(LocalDateTime.now().minusMinutes(5)))
                .isPresent();
    }
}
