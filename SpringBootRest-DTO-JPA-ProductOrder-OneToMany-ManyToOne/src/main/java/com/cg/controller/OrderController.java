package com.cg.controller;

import java.util.ArrayList;
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
import com.cg.dto.ProductDTO;
import com.cg.entity.Orders;
import com.cg.entity.Products;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.ProductRepository;
import com.cg.service.OrderService;
import com.cg.service.ProductService;

@RestController
@RequestMapping("/oaoi")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("hello1")
	public String sayhello() {
		return "hello to order one to many controller";
	}
	
	//done
	@GetMapping(path = "/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Orders> getAllOrders(){
//		List<Orders> orderlist=orderService.findAllOrders();
//		List<OrderDTO> orderdtolist=orderlist.stream()
//				.map(OrderDTO::fromEntity)
//				.collect(Collectors.toList());
//		return orderdtolist;
		return orderService.findAllOrders();
	}
	
 
	//done
	@PostMapping("/orders")
	public Orders createOrderdto(@RequestBody Orders orders) throws ResourceNotFoundException  {
		List<Products> existingproducts=new ArrayList<>();
		for(Products product: orders.getProductslist()) {
			Products p=productService.findproductbyid(product.getId())
					.orElseThrow(()-> new ResourceNotFoundException("Product id : "+product.getId()+" not exist"));
			existingproducts.add(p);
		}
		orders.setProductslist(existingproducts);
		return orderService.newOrder(orders);
	}
	//done
	@GetMapping("/orders/{id}")
	public Orders getorderbyid(@PathVariable int id) throws ResourceNotFoundException{
		Orders o=orderService.findOrderById(id).orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + id));
		List<Products> plist=o.getProductslist();
		o.setProductslist(plist);
		return o;
	}
	//done
	@DeleteMapping("/orders/{id}")
	public void deleteorder(@PathVariable int id) throws ResourceNotFoundException {
		Orders o=orderService.findOrderById(id).orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + id));
		o.getProductslist().clear();
		orderService.newOrder(o);
		
		
		orderService.deleteOrderById(id);
	}
	//done
	@PutMapping("/orders/{id}")
	public Orders updateorder(@PathVariable int id,@RequestBody Orders orders) {
		
		
		return orderService.updateOrders(id, orders);
		
	}
	
}






