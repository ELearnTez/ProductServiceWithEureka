package com.elearntez.springboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class ProductConsumerApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext context = SpringApplication.run(ProductConsumerApplication.class, args);
		ProductClient client = context.getBean("productClient", ProductClient.class);
		client.consumeProducts();
	}

}

