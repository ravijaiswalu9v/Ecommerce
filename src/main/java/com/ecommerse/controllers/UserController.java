package com.ecommerse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerse.entities.User;
import com.ecommerse.servicesimpl.UserServicesImpl;

@RestController
public class UserController {
	
	@Autowired
	UserServicesImpl services;

	@RequestMapping("/")
	public String home() {
		return "this is home page buddy";
	}


//	@RequestMapping(value="/baby",method = RequestMethod.GET)
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Ravi";
	}
//---------------------------------------------------------
	
	//Read all the users
	@GetMapping("/user")
	public List<User> getAllUser(){
		return services.getAllUser();
	}
	
	
	// get a user by specific id
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return services.getUserByID(id);
	}
	
	//new user
	// post mapping(create) the data(users)
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		User u = services.addUser(user);
		return u;
	}
	
	@PostMapping("/users")
	public List<User> addAllUser(@RequestBody List<User> users){
		return services.addAllUser(users);
	}
	
	//Delete a user
	@DeleteMapping("/user/{id}")
	public void deleteById(@PathVariable int id) {
		services.deleteById(id);
	}
	
	//Delete all users
	@DeleteMapping("/user")
	public void deleteAllUsers() {
		services.deleteAllUsers();
	}
	
	//Update user
	@PutMapping("/user/{id}")
	public void UpdateById(@PathVariable("id") int uid, @RequestBody User newUser) {
		services.UpdateById(uid,newUser);
	}
}
