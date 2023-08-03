package com.ecommerse.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecommerse.entities.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{

}
