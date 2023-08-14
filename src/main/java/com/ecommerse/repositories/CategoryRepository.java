package com.ecommerse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerse.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
