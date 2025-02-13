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
import org.springframework.http.ResponseEntity;

import com.cg.dto.DepartmentDTO;
import com.cg.entity.Department;
import com.cg.feign.DepartmentFeignClient;
import com.cg.service.DepartmentService;


@RestController
@RequestMapping("/dpt")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DepartmentFeignClient departmentFeignClient;
	
	@GetMapping("hello")
	public String sayhello() {
		return "hello to department controller microservice";
	}
	
	
	@GetMapping(path = "/departments", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<DepartmentDTO> getAllDepartment(){
		List<Department> departmentlist=departmentService.findAllDepartment();
		List<DepartmentDTO> departmentdtolist=departmentlist.stream()
				.map(DepartmentDTO::fromEntity)
				.collect(Collectors.toList());
		return departmentdtolist;
	}
	

	@PostMapping("/departments")
	public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO) {
		Department d1=departmentDTO.toEntity();
		Department d=departmentService.newDepartment(d1);
		return departmentDTO.fromEntity(d);
	}
	
	//it will call employeeResponse method in DepartmentFeignClient
	@GetMapping(path="/allemp",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getEmployee(){
		return ResponseEntity.ok().body(departmentFeignClient.employeeResponse());
	}
	
	
	
}




