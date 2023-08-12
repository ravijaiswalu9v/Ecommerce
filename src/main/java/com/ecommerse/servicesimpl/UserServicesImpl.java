package com.ecommerse.servicesimpl;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerse.entities.User;
import com.ecommerse.repositories.UserRepository;
import com.ecommerse.services.UserService;

@Component
@JavaBean // need info what this is used for
public class UserServicesImpl implements UserService {

	@Autowired
	UserRepository repo;

	public List<User> getAllUser() {
		List<User> user = null;

		Iterable<User> result = repo.findAll();
		user = (List<User>) result;

//		to view the data on console
//		result.forEach(e -> {
//			System.out.println(e);
//			
//		});

		return user;
	}

	// adding the user
	public User addUser(User u) {
		return repo.save(u);
	}

	public User getUserByID(int id) {
		Optional<User> optional = repo.findById(id);
		User user = optional.get();
		return user;
	}

	public List<User> addAllUser(List<User> users) {
		Iterable<User> itr = repo.saveAll(users);
		return (List<User>) itr;
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

	public void deleteAllUsers() {
		repo.deleteAll();
	}

	//update a user
	public void UpdateById(int id, User newUser) {
		Optional<User> optional = repo.findById(id);
		User user = optional.get();
		user = newUser;
		repo.save(user);
	}

}
