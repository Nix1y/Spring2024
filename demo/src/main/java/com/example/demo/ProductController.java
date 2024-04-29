package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;


@Controller
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;	
	}
	
	@GetMapping("/Products")// This is for the GET HTTP Request, to get the data and display it.
	public String Products(Model model) {
		var products = productService.findAll();
		model.addAttribute("products",products);
		return "products";
	}
	
	@PostMapping(path="/Products") //This is for the POST HTTP Requests, here we are sending the data to be added through the form
		public String addProduct(@RequestParam String name, @RequestParam double price, Model model) {
			Product p = new Product();
			p.setName(name);
			p.setPrice(price);
			productService.addProduct(p);
			
			var products = productService.findAll();
			model.addAttribute("products",products);
			return "products.html";
	}
}
