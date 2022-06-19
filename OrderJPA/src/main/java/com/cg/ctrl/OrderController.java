package com.cg.ctrl;

import java.util.List;  

import com.cg.model.Order;
import com.cg.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	//http://localhost:8080/ProductApp/api/v1/orders
	//@SuppressWarnings("unchecked")
	@PutMapping("/orders")
	public ResponseEntity<List<Order>> updateProduct(
			@RequestBody Order order){
		System.out.println(order);
		List<Order> orders= orderService.updateOrder(order);
		if(orders.isEmpty())
		{
			return new ResponseEntity("Sorry! Orders not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

	//@SuppressWarnings("unchecked")
	@PostMapping("/orders")
	public ResponseEntity<List<Order>> insertOrder(
			@RequestBody Order order){
		List<Order> orders= orderService.saveOrder(order);
		if(orders.isEmpty())
		{
			return new ResponseEntity("Sorry! Order not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	//Note:-use this method for saving
	/*
	 * @PostMapping("save/Order") public ResponseEntity<Order> saveOrder(
	 * 
	 * @RequestBody Order product){ Order orders= orderService.saveOrder2(orderId);
	 * if(orders==null) { return new ResponseEntity("Sorry! Orders not available!",
	 * HttpStatus.NOT_FOUND); }
	 * 
	 * return new ResponseEntity<Order>(orders, HttpStatus.OK); }
	 */
	
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<List<Order>> deleteOrder(
			@PathVariable("orderId")Integer orderId){
		List<Order> orders= orderService.deleteOrder(orderId);
		if(orders.isEmpty() || orders==null) {
			return new ResponseEntity("Sorry! OrderId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Order> findOrder(
			@PathVariable("orderId")Integer orderId){
		Order orders= orderService.findOrder(orderId);
		if(orders==null) {
			return new ResponseEntity("Sorry! Orders not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Order>(orders, HttpStatus.OK);
	}

	
	//http://localhost:8080/ProductApp/api/v1/products/getproduct
	@GetMapping("/orders/getorder")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> orders= orderService.getAllOrders();
		if(orders.isEmpty()) {
			return new ResponseEntity("Sorry! Order not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	////http://localhost:8080/ProductApp/api/v1/products
	@GetMapping("/ordersdate/{orderDate}")
	public ResponseEntity<List<Order>> getAllOrdersByDate(@PathVariable("orderDate")String orderDate){
		System.out.println("inside order");
	
		List<Order> orders= orderService.findByOrderDate(orderDate);
		if(orders.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/orders/price/{orderPr}")
	public ResponseEntity<List<Order>> findOrderAbovePrice(
			@PathVariable("OrderPr")Double price){
		System.out.println("value "+ price);
		List<Order> orders= orderService.findOrderAbovePrice(price);
		if(orders.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
}
