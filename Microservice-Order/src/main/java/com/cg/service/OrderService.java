package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Orders;
import com.cg.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	OrderRepository orderRepository;

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
	public Orders updateOrders(int id, Orders orders) {
		Orders o=orderRepository.findById(id).get();
		o.setOdate(orders.getOdate());
		return orderRepository.save(o);
	}

}
