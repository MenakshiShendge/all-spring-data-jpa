package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Orders;
import com.cg.entity.Products;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.OrderRepository;
import com.cg.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Orders> findAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Orders> findOrderById(int id) {
		return orderRepository.findById(id);
	}

	@Override
	public void deleteOrderById(int id) {
		orderRepository.deleteById(id);
	}

	@Override
	public Orders newOrder(Orders orders) {
		
		return orderRepository.save(orders);
	}

	@Override
	public Orders updateOrders(int id, Orders orders) throws EntityNotFoundException{
		Orders o=orderRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Order with id "+id +" not found"));
		List<Products> plist=new ArrayList<>();
		for(Products p: orders.getProductslist()) {
			Products validp=productRepository.findById(p.getId())
					.orElseThrow(()-> new EntityNotFoundException("product with id "+p.getId() +" not found"));
			plist.add(validp);
		}
		o.setOdate(orders.getOdate());
		o.setProductslist(plist);
		return orderRepository.save(o);
	}

}
