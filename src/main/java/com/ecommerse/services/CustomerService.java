package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Customer;
import com.ecommerse.models.CustomerDTO;

public interface CustomerService {
	public CustomerDTO registerCustomer(Customer customer);
	public void updateDetails(int id, Customer newCustomer);
	
	public List<CustomerDTO> getAllCustomer();
	public CustomerDTO getCustomerByID(int id);
	public String deleteCustomerById(int id);
	public void deleteAllCustomers();

	
	
	
}
