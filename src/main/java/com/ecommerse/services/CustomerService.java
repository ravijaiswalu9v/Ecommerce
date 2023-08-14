package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Customer;
import com.ecommerse.models.CustomerDTO;

public interface CustomerService {
	public List<CustomerDTO> getAllCustomer();
	public CustomerDTO addCustomer(Customer u);
	public CustomerDTO getCustomerByID(int id);
	public List<CustomerDTO> addAllCustomer(List<Customer> customers);
	public void deleteById(int id);
	public void deleteAllCustomers();
	public void UpdateById(int id, Customer newCustomer);
}
