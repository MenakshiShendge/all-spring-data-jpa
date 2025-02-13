package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Employee;
import com.cg.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee newEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

}
