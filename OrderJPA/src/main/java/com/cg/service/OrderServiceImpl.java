
package com.cg.service;
import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.dao.OrderRepository;
import com.cg.model.Order;
@Service
@Repository
public class OrderServiceImpl implements IOrderService
{
	@Autowired
	private OrderRepository orderRepo;
	//

	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	public Order findOrder(Integer OrderId) {
		Optional<Order>prod=orderRepo.findById(OrderId);
		return prod.get();
	}
	public List<Order> deleteOrder(Integer OrderId) {
		orderRepo.deleteById(OrderId);
		return  orderRepo.findAll();
	}
	public List<Order> saveOrder(Order Order) {
		orderRepo.saveAndFlush(Order);
		return  orderRepo.findAll();
	}
	
	
	public Order saveOrder2(Order Order) {
	System.out.println("inside save2");
		return orderRepo.save(Order);
	}

	public List<Order> updateOrder(Order Order) {
		orderRepo.saveAndFlush(Order);
		return  orderRepo.findAll();
	}

	public List<Order> saveAll() {
		return null;
	}

	@Override
	public List<Order> findByOrderDate(String ordDate) {
		List<Order> prd=orderRepo.findByOrderId(ordDate);
		return prd;
	}
	
	@Override
	public List<Order> findOrderAbovePrice(Double price) {
		List<Order> prd=orderRepo.getByPrice(price);
		return prd;
	}
}
