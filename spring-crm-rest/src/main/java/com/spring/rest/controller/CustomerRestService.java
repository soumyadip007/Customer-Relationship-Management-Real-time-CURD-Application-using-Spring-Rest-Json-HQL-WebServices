package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Customer;
import com.spring.rest.exception.CustomerNotFoundException;
import com.spring.rest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestService {

	//Autowire the customer service
	@Autowired
	private CustomerService customerService;
	

	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer customerId(@PathVariable int customerId)
	{
		
		Customer obj=customerService.getCustomer(customerId);
		
		if(obj==null)
		{
			throw new CustomerNotFoundException("Customer ID not found -"+customerId);
		}
		
		return obj;
	}
	
	//Add mapping for POST/Customer - add new customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		
		customer.setId(0); //if id is 0,then DAO will "Insert" new customer
		
		customerService.saveCustomer(customer);
		 
		return customer;
	}
	
	//Add mapping for PUT/Customer - update new customer
	
		@PutMapping("/customers")
		public Customer updateCustomer(@RequestBody Customer customer)
		{
			
			customerService.saveCustomer(customer);
			 
			return customer;
		}
}
