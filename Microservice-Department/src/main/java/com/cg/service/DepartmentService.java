package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Department;
import com.cg.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> findAllDepartment() {
		
		return departmentRepository.findAll();
	}

	@Override
	public Department newDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	

}
