package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestService {

	//Autowire the customer service
	@Autowired
	private CustomerService customerService;
	

}
