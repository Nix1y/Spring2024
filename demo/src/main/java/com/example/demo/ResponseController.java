package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@GetMapping("/hello")
	@ResponseBody()
	public String hello() {
		return "hello";
	}
	
	//multiple methods, we will have to write response body for each call
	
	@GetMapping("/kieth")
	@ResponseBody()
	public String kieth() {
		return "kieth";
	}

}
