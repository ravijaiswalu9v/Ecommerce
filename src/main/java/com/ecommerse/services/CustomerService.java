package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Customer;
import com.ecommerse.models.CustomerDTO;

public interface CustomerService {
	public CustomerDTO registerCustomer(Customer u);
	public CustomerDTO viewDetails(int id);
	public void updateDetails(int id, Customer newCustomer);
}
