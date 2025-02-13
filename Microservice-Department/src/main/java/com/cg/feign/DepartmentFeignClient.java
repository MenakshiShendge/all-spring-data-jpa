package com.cg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="employee-service",url = "http://localhost:8080")
public interface DepartmentFeignClient {

	@GetMapping("/emp/employees")
	public String employeeResponse() ;
}
