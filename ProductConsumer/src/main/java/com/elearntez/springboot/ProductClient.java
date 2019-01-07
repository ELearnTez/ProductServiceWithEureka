package com.elearntez.springboot;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	public void consumeProducts() throws RestClientException, IOException {
		String baseUrl = discoveryClient.getInstances("product-service").get(0).getUri().toString();
		
		System.out.println("-------------------------------");
		System.out.println("BaseUrl : "+baseUrl);
		System.out.println("-------------------------------");
				
		String url = baseUrl+ "/products";
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Product>> response = restTemplate.exchange(
				url, HttpMethod.GET, constructHttpHeader(),
				new ParameterizedTypeReference<List<Product>>(){});
		
		response.getBody().forEach(System.out::println);
		
	}
	
	
	private static HttpEntity<?> constructHttpHeader() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	
}
