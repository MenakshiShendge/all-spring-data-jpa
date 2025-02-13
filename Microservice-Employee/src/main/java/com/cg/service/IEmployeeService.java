package com.cg.service;

import java.util.List;

import com.cg.entity.Employee;

public interface IEmployeeService {

	public List<Employee> findAllEmployee();
	public Employee newEmployee(Employee employee);
}
