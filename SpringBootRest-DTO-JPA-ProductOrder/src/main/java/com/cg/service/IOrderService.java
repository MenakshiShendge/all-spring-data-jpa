package com.cg.service;
import java.util.*;

import com.cg.entity.Orders;
public interface IOrderService {
	
	public List<Orders> findAllOrders();
	public Optional<Orders> findOrderById(int id);
	public void deleteOrderById(int id);
	public Orders newOrder(Orders orders);
	public Orders updateOrders(int id,Orders orders);

}
