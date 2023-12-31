package com.ecommerse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ecommerse.entities.User;
import com.ecommerse.repositories.UserRepository;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EcommerceApplication.class, args);
		UserRepository userRepository =  context.getBean(UserRepository.class);
		
		// creating user object
		User user = new User();
//		user.setId(454);
		user.setName("Mahadevi");
		user.setAddress("Kashi");
		user.setEmail("kali.gmail.com");
		user.setPassword("23125");
		user.setPhone("123456789012");
		user.setPic("Loading..");
		
		User user1 = userRepository.save(user);
		System.out.println(user1);
		
	}

}
