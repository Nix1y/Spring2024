//Demo using REST Controller
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/restHello")
	public String restHello() {
		return "hello";
	}
	
	@GetMapping("/katty")
	public String katty() {
		return "katty";
	}
}
