package com.ecommerse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerse.entities.Customer;
import com.ecommerse.servicesimpl.CustomerServicesImpl;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServicesImpl services;

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
	public List<Customer> getAllCustomer(){
		return services.getAllCustomer();
	}
	
	
	// get a customer by specific id
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return services.getCustomerByID(id);
	}
	
	//new customer
	// post mapping(create) the data(customers)
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer u = services.addCustomer(customer);
		return u;
	}
	
	@PostMapping("/customers")
	public List<Customer> addAllCustomer(@RequestBody List<Customer> customers){
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
	public void UpdateById(@PathVariable("id") int uid, @RequestBody Customer newCustomer) {
		services.UpdateById(uid,newCustomer);
	}
}
