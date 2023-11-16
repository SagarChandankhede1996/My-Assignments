package com.service;

import com.Repository.EmployeeRepository;
import com.models.Employee;

public class EmployeeService {

	EmployeeRepository employeeRepository=new EmployeeRepository();
	public void insertEmployee(Employee employee) {
		employeeRepository.insertEmployee(employee);
	}

}
