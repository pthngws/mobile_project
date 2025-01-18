package com.web_mobile.restcontroller;

import com.web_mobile.dto.ForgotPasswordRequest;
import com.web_mobile.dto.RegisterRequest;
import com.web_mobile.dto.OtpVerificationRequest;
import com.web_mobile.dto.ResetPasswordRequest;
import com.web_mobile.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request.getEmail(), request.getPassword());
        return ResponseEntity.ok("Registration successful. Check your email for OTP.");
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activate(@RequestBody OtpVerificationRequest request) {
        authService.activateAccount(request.getEmail(), request.getOtp());
        return ResponseEntity.ok("Account activated successfully.");
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        authService.forgotPassword(request.getEmail());
        return ResponseEntity.ok("OTP sent to your email.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        authService.resetPassword(request.getEmail(), request.getOtp(), request.getNewPassword());
        return ResponseEntity.ok("Password reset successful.");
    }
}
