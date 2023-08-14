package com.ecommerse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ecommerse.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
