package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class EmployeeController {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/users")
	public Employee[] getDetails() {
		// ResponseEntity<Employee[]> response =restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users",Employee[].class);
		// return Arrays.asList(response.getBody());
		Employee[] response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", Employee[].class);	//Get only Geo Object and Company Name(i.e only specific data).
		return response;
	}

	@RequestMapping(value = "/getAllData")
	public ResponseEntity<String> getAllDetails() throws JsonMappingException, JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange("https://jsonplaceholder.typicode.com/users", HttpMethod.GET, entity,String.class);	//Get All data that are available inside that API.
	}

}
