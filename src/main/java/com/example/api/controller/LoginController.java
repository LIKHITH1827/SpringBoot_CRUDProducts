package com.example.api.controller;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import com.example.api.model.Product;
	import com.example.api.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

	@RestController
	public class LoginController {
		private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
		@Autowired
		ProductService productService;
		
		
		@GetMapping("/")
		public String Home(HttpServletRequest request) {
			logger.info("Home page");
			return "This is Home " + request.getSession().getId();
		}

				
		
		
	}


