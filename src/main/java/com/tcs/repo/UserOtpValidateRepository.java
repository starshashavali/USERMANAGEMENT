package com.tcs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.domain.UserOtpValidate;

public interface UserOtpValidateRepository  extends JpaRepository<UserOtpValidate, Long>{
	
	UserOtpValidate findByEmail(String email);

	UserOtpValidate findByEmailAndOtp(String email,String  otp);
	
	

}
