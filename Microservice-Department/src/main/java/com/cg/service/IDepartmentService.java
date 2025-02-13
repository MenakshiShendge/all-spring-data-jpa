package com.cg.service;

import java.util.List;

import com.cg.entity.Department;

public interface IDepartmentService {

	public List<Department> findAllDepartment();
	public Department newDepartment(Department department);
}
