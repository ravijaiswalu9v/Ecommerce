package com.ecommerse.servicesimpl;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerse.entities.Customer;
import com.ecommerse.models.CustomerDTO;
import com.ecommerse.repositories.CustomerRepository;
import com.ecommerse.services.CustomerService;
import com.ecommerse.util.Converter;

@Component
@JavaBean // need info what this is used for
public class CustomerServicesImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	Converter converter;

	

	// adding the user
	public CustomerDTO registerCustomer(Customer u) {
		Customer customer = customerRepository.save(u);
		return converter.convertToCustomerDTO(customer);
	}

	public CustomerDTO viewDetails(int id) {
		Customer customer = customerRepository.findById(id).get();
		return converter.convertToCustomerDTO(customer);
	}


	// update a user
	public void updateDetails(int id, Customer newCustomer) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer customer = optional.get();
		customer.setId(id);
		customer.setName(newCustomer.getName());
		customer.setEmail(newCustomer.getEmail());
		customer.setAddress(newCustomer.getAddress());
		customer.setPassword(newCustomer.getPassword());
		customer.setPhone(newCustomer.getPhone());
		customer.setPic(newCustomer.getPic());
		customerRepository.save(customer);
	}

	

}
