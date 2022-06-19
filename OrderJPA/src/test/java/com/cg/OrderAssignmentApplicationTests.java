package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dao.OrderRepository;
import com.cg.model.Order;
import com.cg.service.OrderServiceImpl;


@SpringBootTest
class OrderJPAApplicationTests {

	@Autowired
	private OrderServiceImpl ordService;
	
	@MockBean
	private OrderRepository ordRepo;

	@Test
	public void saveOrderTest() {
		Order o=new Order(27, 45, 90000.00, LocalDate.of(2022, 6, 10));
		when(ordRepo.save(o)).thenReturn(o);
		assertEquals(o,ordService.saveOrder2(o));
	}
	
	@Test
	public void deleteOrderTest() {
		Order o = new Order(27, 45, 90000.00, LocalDate.of(2022, 6, 10));
		ordService.deleteOrder(27);
		verify(ordRepo,times(1)).deleteById(27);
	}

}
