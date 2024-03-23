package com.tcs.service;

import com.tcs.domain.Employee;

public interface EmployeeService {

	public String employeeRegistration(Employee employee);
	
	public String UserOtpValidateSave(Employee employee);
	
	public String verifyOtp(String email,String otp);
	

	public String login(String email, String password);
	
	
	

}
