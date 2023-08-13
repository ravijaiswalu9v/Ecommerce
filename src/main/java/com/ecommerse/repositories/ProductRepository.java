package com.ecommerse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerse.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

}
