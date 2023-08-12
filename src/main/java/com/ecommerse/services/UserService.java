package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.User;

public interface UserService {
	public List<User> getAllUser();
	public User addUser(User u);
	public User getUserByID(int id);
	public List<User> addAllUser(List<User> users);
	public void deleteById(int id);
	public void deleteAllUsers();
	public void UpdateById(int id, User newUser);
}
