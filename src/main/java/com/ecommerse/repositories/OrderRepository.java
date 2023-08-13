package com.ecommerse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerse.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Integer>{

}
