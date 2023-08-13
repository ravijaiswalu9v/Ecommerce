package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomer();
	public Customer addCustomer(Customer u);
	public Customer getCustomerByID(int id);
	public List<Customer> addAllCustomer(List<Customer> customers);
	public void deleteById(int id);
	public void deleteAllCustomers();
	public void UpdateById(int id, Customer newCustomer);
}
