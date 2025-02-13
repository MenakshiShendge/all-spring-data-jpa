package com.cg.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.cg.dto.OrderDTO;
import com.cg.entity.Orders;
import com.cg.exception.ResourceNotFoundException;
import com.cg.service.OrderService;

@RestController
@RequestMapping("/oaoi")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("hello")
	public String sayhello() {
		return "hello to order controller microservice";
	}
	
	
	@GetMapping(path = "/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderDTO> getAllOrders(){
		List<Orders> orderlist=orderService.findAllOrders();
		List<OrderDTO> orderdtolist=orderlist.stream()
				.map(OrderDTO::fromEntity)
				.collect(Collectors.toList());
		return orderdtolist;
	}
	

	@PostMapping("/orders")
	public OrderDTO createOrderdto(@RequestBody OrderDTO orderDTO) {
		Orders o1=orderDTO.toEntity();
		Orders o=orderService.newOrder(o1);
		return orderDTO.fromEntity(o);
	}
	
	@GetMapping("/orders/{id}")
	public OrderDTO getorderbyid(@PathVariable int id) throws ResourceNotFoundException{
		OrderDTO orderDTO =new OrderDTO();
		
		return orderDTO.fromEntity(orderService.findOrderById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id)));
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteorder(@PathVariable int id) {
		orderService.deleteOrderById(id);
	}
	
	@PutMapping("/orders/{id}")
	public OrderDTO updateorder(@PathVariable int id,@RequestBody OrderDTO orderDTO) {
		Orders o1=orderDTO.toEntity();
		Orders o=orderService.updateOrders(id, o1);
		return orderDTO.fromEntity(o);
		
	}
	
}






