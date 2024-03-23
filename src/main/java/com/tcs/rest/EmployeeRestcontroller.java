package com.tcs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.domain.Employee;
import com.tcs.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestcontroller {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmp")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		String status = employeeService.employeeRegistration(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(status);

	}

	@PostMapping("/saveUservalidation")
	public ResponseEntity<?> saveUserValidation(@RequestBody Employee employee) {
		String status = employeeService.UserOtpValidateSave(employee);
		return ResponseEntity.status(HttpStatus.OK).body(status);

	}

	@GetMapping("/verifyOtp")
	public ResponseEntity<?> verifyOtpUserValidation(@RequestParam String email,@RequestParam String otp) {
		String status = employeeService.verifyOtp(email, otp);
		
		System.out.println(otp);
		return ResponseEntity.status(HttpStatus.OK).body(status);

	}

}
