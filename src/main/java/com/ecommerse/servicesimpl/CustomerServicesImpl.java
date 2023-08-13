package com.ecommerse.servicesimpl;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerse.entities.Customer;
import com.ecommerse.repositories.CustomerRepository;
import com.ecommerse.services.CustomerService;

@Component
@JavaBean // need info what this is used for
public class CustomerServicesImpl implements CustomerService {

	@Autowired
	CustomerRepository repo;

	public List<Customer> getAllCustomer() {
		List<Customer> customer = null;

		Iterable<Customer> result = repo.findAll();
		customer = (List<Customer>) result;

//		to view the data on console
//		result.forEach(e -> {
//			System.out.println(e);
//			
//		});

		return customer;
	}

	// adding the user
	public Customer addCustomer(Customer u) {
		return repo.save(u);
	}

	public Customer getCustomerByID(int id) {
		Optional<Customer> optional = repo.findById(id);
		Customer customer = optional.get();
		return customer;
	}

	public List<Customer> addAllCustomer(List<Customer> customers) {
		Iterable<Customer> itr = repo.saveAll(customers);
		return (List<Customer>) itr;
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

	public void deleteAllCustomers() {
		repo.deleteAll();
	}

	//update a user
	public void UpdateById(int id, Customer newCustomer) {
		Optional<Customer> optional = repo.findById(id);
		Customer customer = optional.get();
		customer.setId(id);
		customer.setName(newCustomer.getName());
		customer.setEmail(newCustomer.getEmail());
		customer.setAddress(newCustomer.getAddress());
		customer.setPassword(newCustomer.getPassword());
		customer.setPhone(newCustomer.getPhone());
		customer.setPic(newCustomer.getPic());
		repo.save(customer);
	}

}
