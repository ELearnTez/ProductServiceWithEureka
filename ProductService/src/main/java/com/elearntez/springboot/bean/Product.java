package com.elearntez.springboot.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private int id;
	private String name;
	private String description;
	
	
}
