package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	private final LogUserManagementService logUserManagementService;
	public MainController(LogUserManagementService logUserManagementService) {
		this.logUserManagementService = logUserManagementService;
	}
	//for path variable 
	//@RequestMapping("/home/{color}") 
	//public String home(@PathVariable String color;
//	@RequestMapping("/main")
//	public String home(@RequestParam(required=false)String name,@RequestParam(required=false)String color,Model page) {
//		page.addAttribute("userName",name);
//		page.addAttribute("color",color);
//		return "home.html";
//	}
	@GetMapping("/home")
	public String home(@RequestParam(required=false) String logout, Model model) {
		if(logout != null) {
			logUserManagementService.setUsername(null);
		}
		String username = logUserManagementService.getUsername();
		if(username == null) {
			return "redirect:/";
		}
		return "dashboard.html";
	}
}
