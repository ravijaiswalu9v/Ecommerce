package com.ecommerse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerse.entities.Admin;


public interface LoginRepository extends JpaRepository<Admin, Integer>{

}
