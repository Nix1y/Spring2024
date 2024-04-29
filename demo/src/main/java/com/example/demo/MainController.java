package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	//for path variable 
	//@RequestMapping("/home/{color}") 
	//public String home(@PathVariable String color;
	@RequestMapping("/home")
	public String home(@RequestParam(required=false)String name,@RequestParam(required=false)String color,Model page) {
		page.addAttribute("userName",name);
		page.addAttribute("color",color);
		return "home.html";
	}
}
