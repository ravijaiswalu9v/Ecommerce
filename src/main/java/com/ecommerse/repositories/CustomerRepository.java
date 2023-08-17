package com.ecommerse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerse.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
