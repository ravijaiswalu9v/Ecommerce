package com.ecommerse.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerse.entities.Customer;
import com.ecommerse.models.CustomerDTO;
import com.ecommerse.services.CustomerService;
import com.ecommerse.servicesimpl.CustomerServicesImpl;
import com.ecommerse.util.Converter;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	Converter converter;

	@RequestMapping("/")
	public String home() {
		return "this is home page buddy";
	}


//	@RequestMapping(value="/baby",method = RequestMethod.GET)
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Ravi";
	}
//---------------------------------------------------------
	//customer can Register
	@PostMapping("customer/new")
	public ResponseEntity<CustomerDTO> registerCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		final Customer customer = converter.covertToCustomerEntity(customerDTO);
		return new ResponseEntity<CustomerDTO>(customerService.registerCustomer(customer),HttpStatus.OK );
	}
	
	
	// customer can see there details
	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
		CustomerDTO customerDTO = customerService.getCustomerByID(id);
		if (customerDTO!=null) {
			return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.OK );
		}
		return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.NOT_FOUND);
	}
	
	//Update customer
	@PutMapping("/customer/{id}")
	public void updateDetails(@PathVariable("id") int uid,@Valid @RequestBody Customer newCustomer) {
		customerService.updateDetails(uid, newCustomer);
	}
	
	//when customer creates 
}
