package com.cg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="product-service",url = "http://localhost:9090")
public interface OrderFeignClient {
	
	@GetMapping("papi/products")
	public String productResponse();

}
