package com.tcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.domain.Employee;
import com.tcs.domain.UserOtpValidate;
import com.tcs.repo.EmployeeRepository;
import com.tcs.repo.UserOtpValidateRepository;
import com.tcs.service.EmployeeService;
import com.tcs.utils.EmailUtils;
import com.tcs.utils.OTPUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserOtpValidateRepository userOtpValidationRepository;

	@Autowired
	private OTPUtils otpUtils;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String employeeRegistration(Employee employee) {

		UserOtpValidate existingUser = userOtpValidationRepository.findByEmail(employee.getEmail());

		if (existingUser != null) {
			return "Duplicate Email...";

		}

		String generateRandomOtp = otpUtils.generateRandomOtp();
		// int otp = Integer.parseInt(generateRandomOtp);

		employee.setOtp(generateRandomOtp);

		String subject = "Thank you for Registering, please enter your OTP to proceed further!!!";
		String text = "<h4>Please use the below OTP to proceed further... </h4> " + "<p>Your OTP is</p>"
				+ generateRandomOtp;
		emailUtils.sendEmail(employee.getEmail(), subject, text);

		UserOtpValidate userOtp = new UserOtpValidate();
		userOtp.setEmail(employee.getEmail());
		userOtp.setOtp(generateRandomOtp);
		userOtp.setPhone(employee.getPhone());

		userOtpValidationRepository.save(userOtp);

		if (!userOtp.getOtp().equals(employee.getOtp())) {
			return "Invalid OTP";

		}

		employeeRepository.save(employee);

		return null;
	}

//save data to send otp
	public String UserOtpValidateSave(Employee employee) {

		UserOtpValidate existingUser = userOtpValidationRepository.findByEmail(employee.getEmail());

		if (existingUser != null) {
			return "Duplicate Email...";

		}

		UserOtpValidate userOtp = new UserOtpValidate();
		userOtp.setEmail(employee.getEmail());

		String generateRandomOtp = otpUtils.generateRandomOtp();
		// int otp = Integer.parseInt(generateRandomOtp);

		String subject = "Thank you for Registering, please enter your OTP to proceed further!!!";
		String text = "<h4>Please use the below OTP to proceed further... </h4> " + "<p>Your OTP is</p>"
				+ generateRandomOtp;
		emailUtils.sendEmail(employee.getEmail(), subject, text);

		employee.setOtp(generateRandomOtp);
		userOtp.setOtp(generateRandomOtp);
		userOtp.setPhone(employee.getPhone());
		userOtpValidationRepository.save(userOtp);
		return "Success";

	}

	public String verifyOtp(String email, String otp) {

		UserOtpValidate userOtp = userOtpValidationRepository.findByEmailAndOtp(email, otp);

		if (userOtp != null) {
			if (otp.equals(userOtp.getOtp())) {
				return "Verification done";
			}
		}
		return "Invalid otp";
	}

	@Override
	public String login(String email, String password) {
		
		
		

		return null;
	}

}
