package com.cg.dao;

/*Spring Data JPA to reduce the amount of boilerplate code
 *  required to implement the data access object (DAO) layer.*/
/*
 * Implementing a data access layer of an application has been cumbersome 
 * for quite a while.
 *  Too much boilerplate code has to be written to execute simple queries 
 *  as well as perform pagination, and auditing. 
 *  Spring Data JPA aims to significantly improve the implementation of
 *   data access layers by reducing the effort to the amount that’s actually needed. 
 *   As a developer you write your repository interfaces, including custom finder methods, 
 *   and Spring will provide the implementation automatically.
 */
/*It hides the data store specific implementation details and enables you to implement your business code on a higher abstraction level.

Implementing that pattern isn’t too complicated but writing the
 standard CRUD operations for each entity creates a lot of repetitive code. Spring Data JPA provides you a set of repository interfaces which you only need to extend to define a specific repository for one of your entities
 */

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	public List<Order> findByOrderId(String ordId);

	@Query("SELECT ord FROM Order ord  WHERE ord.price>=:pri ") // JPQL
	public List<Order> getByPrice(@Param("pri") double price);
}
