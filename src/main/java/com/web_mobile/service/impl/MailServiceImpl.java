package com.web_mobile.service.impl;

import com.web_mobile.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public void sendOtp(String email, String otp) {
        System.out.println("Sending OTP to " + email + ": " + otp);

    }
}
