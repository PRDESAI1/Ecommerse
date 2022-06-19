package com.cg.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="product")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int orderId;
	
	/*
	 * @Column(name="order_date") private String productDate;
	 */
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total_price")
	private double price;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	//@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private LocalDate orderDate;
	
	public Order() {
		
	}
	
	public Order(int orderId, int quantity, double price, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity
				+ ", price=" + price + ", orderDate=" + orderDate + "]";
	}
	
	
	

}
