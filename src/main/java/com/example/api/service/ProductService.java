package com.example.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.model.Product;
import com.example.api.repository.ProductRepo;

@Service
public class ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	ProductRepo repo;

//List<Product> products= new ArrayList<>(Arrays.asList(new Product(1, "Car", 100000), new Product(2, "Bike", 50000), new Product(3, "Cycle", 1000)));
	
	public List<Product> getProducts(){
		logger.debug("Fetching all products");
		//return products;
		return repo.findAll();
	}
	
	public Product getProductById(int prodId) {
		logger.debug("Fetching product with ID: {}", prodId);
		//return products.stream().filter(p -> p.getProdId() == prodId).findFirst().orElse(null);
		return repo.findById(prodId).orElse(null);
	}
	
   public void addProduct(Product product) {
//	   products.add(product);
	   repo.save(product);
   }

public void updateProduct(Product product) {
	// TODO Auto-generated method stub
	/*
	 for(int i=0; i<products.size();i++) {
		if(products.get(i).getProdId()==product.getProdId()) {
			products.get(i).setPrice(product.getPrice());
			products.get(i).setProdName(product.getProdName());
			return;
		} 
	} */
	repo.save(product);
}

public void deleteProduct(int prodId) {
	// TODO Auto-generated method stub
//	for(int i=0; i<products.size();i++) {
//		if(products.get(i).getProdId()==prodId) {
//			products.remove(i);
//		}
//	}
	repo.deleteById(prodId);
}
}
