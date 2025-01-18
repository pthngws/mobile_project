package com.web_mobile.service;

public interface AuthService {
    void register(String email, String password);

    void activateAccount(String email, String otp);

    void forgotPassword(String email);

    void resetPassword(String email, String otp, String newPassword);
}
