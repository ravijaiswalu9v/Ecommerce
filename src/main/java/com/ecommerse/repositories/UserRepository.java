package com.ecommerse.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecommerse.entities.User;


public interface UserRepository extends CrudRepository<User, Integer>{

}
