package com.ecommerse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerse.entities.Customer;
import com.ecommerse.models.CustomerDTO;
import com.ecommerse.services.CustomerService;
import com.ecommerse.util.Converter;

import jakarta.validation.Valid;

@RestController
public class LoginSignupController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	Converter converter;
	
	@PostMapping("customer/signup")
	public CustomerDTO customerRegistration(@Valid @RequestBody CustomerDTO customerDTO) {
		Customer customer = converter.covertToCustomerEntity(customerDTO);
		return customerService.addCustomer(customer);
	}
}
