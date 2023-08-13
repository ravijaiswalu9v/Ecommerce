package com.ecommerse.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecommerse.entities.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
