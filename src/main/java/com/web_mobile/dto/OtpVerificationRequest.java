package com.web_mobile.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpVerificationRequest {
    private String email;
    private String otp;
}
