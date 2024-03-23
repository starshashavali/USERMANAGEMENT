package com.tcs.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OTPUtils {
	
	    public String generateRandomOtp() {
	        int otpLength = 6;
	        
	        StringBuilder otp = new StringBuilder(otpLength);
	        
	        Random random = new Random();
	        
	        for (int i = 0; i < otpLength; i++) {
	            int digit = random.nextInt(10); // Generate a random digit (0-9)
	            otp.append(digit); // Append the digit to the OTP
	        }
	        
	        return otp.toString();
	    }
	}
