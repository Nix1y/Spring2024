package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/home")
	public String home(Model page) {
		page.addAttribute("userName","katty");
		page.addAttribute("color","blue");
		return "home.html";
	}
}
