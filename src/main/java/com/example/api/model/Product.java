package com.example.api.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
	
    @Id
	private int prodId;
	private String prodName;
	private int price;
	
	public Product() {
		
	}
//	
//	public Product(int prodId, String prodName, int price) {
//		
//		this.price = price;
//		this.prodId = prodId;
//		this.prodName = prodName;
//		
//	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + "]";
	}
	
}
