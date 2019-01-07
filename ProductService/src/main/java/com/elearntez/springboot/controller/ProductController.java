package com.elearntez.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearntez.springboot.bean.Product;

@RestController
public class ProductController {

	@GetMapping("/products")
	public List<Product> getProducts(){
		List<Product> productList = new ArrayList<>();
		
		productList.add(Product.builder().id(1).name("TV").description("VU").build());
		productList.add(Product.builder().id(2).name("washing machine").description("IFB washing machine").build());
		productList.add(Product.builder().id(3).name("Refrigerator").description("SamSung refrigerator").build());
		
		
		
		return productList;
	}
	
	
}
