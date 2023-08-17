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
import com.ecommerse.servicesimpl.CustomerServicesImpl;
import com.ecommerse.util.Converter;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServicesImpl services;
	
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
	
	//Read all the customers
	@GetMapping("/customer")
	public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
		List<CustomerDTO> allCustomer = services.getAllCustomer();
		if(allCustomer.size()!=0)
		return new ResponseEntity<List<CustomerDTO>>(allCustomer,HttpStatus.OK);
		return new ResponseEntity<List<CustomerDTO>>(HttpStatus.NOT_FOUND);
	}
	
	
	// get a customer by specific id
	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
		CustomerDTO customerDTO = services.getCustomerByID(id);
		if (customerDTO!=null) {
			return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.OK );
		}
		return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.NOT_FOUND);
	}
	
	//new customer
	// post mapping(create) the data(customers)
	@PostMapping("/customer")
	public CustomerDTO addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		Customer customer = converter.covertToCustomerEntity(customerDTO);
		return services.addCustomer(customer);
	}
	
	@PostMapping("/customers")
	public List<CustomerDTO> addAllCustomer(@RequestBody List<CustomerDTO> customersDtos){
		List<Customer> customers = new ArrayList<>();
		for (CustomerDTO cDTO :customersDtos ) {
			customers.add(converter.covertToCustomerEntity(cDTO));
		}
		return services.addAllCustomer(customers);
	}
	
	//Delete a customer
	@DeleteMapping("/customer/{id}")
	public void deleteById(@PathVariable int id) {
		services.deleteById(id);
	}
	
	//Delete all customers
	@DeleteMapping("/customer")
	public void deleteAllCustomers() {
		services.deleteAllCustomers();
	}
	
	//Update customer
	@PutMapping("/customer/{id}")
	public void UpdateById(@PathVariable("id") int uid,@Valid @RequestBody Customer newCustomer) {
		services.UpdateById(uid,newCustomer);
	}
}
