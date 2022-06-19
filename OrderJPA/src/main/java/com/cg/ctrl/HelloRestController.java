package com.cg.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller+@ResponseBody
@RequestMapping("/api")
public class HelloRestController {

	@RequestMapping(value="/hello")
	public String sayHello() {
		System.out.println("heelo........");
		return "Hello Cg! from Spring Framework!";
	}
}
