package com.example.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
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
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	
//	@GetMapping("/")
//	public String Home() {
//		logger.info("Home page");
//		return "This is Home";
//	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		logger.info("GET /products");
		return productService.getProducts();
		
	}
	
	@GetMapping("/products/{prodId}")
	public ResponseEntity<Product> getProductById(@PathVariable int prodId) {
		logger.info("GET /products/{}", prodId);
		Product product=productService.getProductById(prodId);
		if(product!=null) {
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		logger.info("Received product: {}", product);
        productService.addProduct(product);
	}
	
	@GetMapping("/csrf-token")
	public  CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
	
	
	@DeleteMapping("/products/{prodId}")
	public void deleteProduct(@PathVariable int prodId) {
		productService.deleteProduct(prodId);
	}
	
	
	
}
