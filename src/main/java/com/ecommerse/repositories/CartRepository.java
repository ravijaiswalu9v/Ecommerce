package com.ecommerse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerse.entities.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer>{

}
