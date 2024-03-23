package com.tcs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	Employee findByEmailAndPassword(String email, String password);
}
