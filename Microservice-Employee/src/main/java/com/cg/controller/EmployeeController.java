package com.cg.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import com.cg.service.EmployeeService;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("hello")
	public String sayhello() {
		return "hello to employee controller microservice";
	}
	
	
	@GetMapping(path = "/employees", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<EmployeeDTO> getAllEmployees(){
		List<Employee> employeelist=employeeService.findAllEmployee();
		List<EmployeeDTO> employeedtolist=employeelist.stream()
				.map(EmployeeDTO::fromEntity)
				.collect(Collectors.toList());
		return employeedtolist;
	}
	

	@PostMapping("/employees")
	public EmployeeDTO createOrderdto(@RequestBody EmployeeDTO employeeDTO) {
		Employee e1=employeeDTO.toEntity();
		Employee e=employeeService.newEmployee(e1);
		return employeeDTO.fromEntity(e);
	}
	
	
	
}






