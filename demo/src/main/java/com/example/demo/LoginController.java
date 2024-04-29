package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	//declaring the loginProcessor variable
	private LoginProcessor loginProcessor;
	
	//passing loginProcessor as argument in the constructor
	public LoginController(LoginProcessor loginProcessor) {
		this.loginProcessor = loginProcessor;
	}
	
	@GetMapping("/")
	public String loginGet() {
		return "login.html";
	}
	
	@PostMapping("/")
	public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {
		boolean isLoggedIn = false;
		//setting values as it does not set automatically from the form itself.
		loginProcessor.setUsername(username);
		loginProcessor.setPassword(password);
		//calling login method
		isLoggedIn = loginProcessor.login();
		if(isLoggedIn) {
			model.addAttribute("message","you are now logged In");
		}
		else {
			model.addAttribute("message","Log In Failed!");
		}
		return "login.html";
	}

	public LoginProcessor getLoginProcessor() {
		return loginProcessor;
	}

	public void setLoginProcessor(LoginProcessor loginProcessor) {
		this.loginProcessor = loginProcessor;
	}
	
}
