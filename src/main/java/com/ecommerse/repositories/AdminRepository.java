package com.ecommerse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerse.entities.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
