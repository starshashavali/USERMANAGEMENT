package com.tcs.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employeeTbl")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	private String email;
	private Long phone;
	
	private String mobileOtp;

	private String password;

	// add OTP field
	private String otp;

	private String gender;
	private Date dob;
	private String designation;
	private String role;

	@Column
	private String registerAs;
	@Column
	private String workStatus;
	@Column
	private String modeOfJob;

	@Column
	private String typeOfJob;
	private Integer years;
	private Integer months;

	@Column
	private Double currentSalary;

	@Column
	private Double expectedSalary1;

	@Column
	private Double expectedSalary2;

	/*
	 * @Lob private byte[] resume;
	 */

	@Column
	private String resumeDescription;

}
