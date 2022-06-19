package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.model.Order;
@Service
@Repository
public interface IOrderService {

	public List<Order> getAllOrders();

	public Order findOrder(Integer OrderId);

	public List<Order> deleteOrder(Integer OrderId);

	public List<Order> saveOrder(Order Order);
	
	public Order saveOrder2(Order Order);

	public List<Order> updateOrder(Order Order);
	public List<Order> saveAll();
	
	public List<Order> findByOrderDate(String prDate);
	
	public List<Order> findOrderAbovePrice(Double price);
}
