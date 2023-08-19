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

	@Override
	public CustomerDTO registerCustomer(Customer customer) {
		return converter.convertToCustomerDTO(customerRepository.save(customer));
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

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customerDTOs = new ArrayList<>();

		for (Customer c : customers) {
			customerDTOs.add(converter.convertToCustomerDTO(c));
		}
		return customerDTOs;
	}

	@Override
	public CustomerDTO getCustomerByID(int id) {
		Customer customer = customerRepository.findById(id).get();
		return converter.convertToCustomerDTO(customer);
	}

	@Override
	public String deleteCustomerById(int id) {
		customerRepository.deleteById(id);
		return "The customer of ID:" + id + " has been deleted Successfully!..";
	}

	@Override
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
		
	}

	


}
