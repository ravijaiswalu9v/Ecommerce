package com.ecommerse.models;

import java.sql.Blob;

import com.ecommerse.entities.Cart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDTO {
	
	private int id;
	
	@NotNull
	@Size(min = 3, max = 50, message = "The name should be minimum of 3 letter or maximum of 50 letter")
	private String name;
	
	@NotNull
	@Size(min = 3, max = 50, message = "The email should be minimum of 25 letter or maximum of 50 letter")
	private String email;
	
	@NotNull
	@Size(min = 3, max = 50, message = "The password should be minimum of 5 letter or maximum of 50 letter")
	private String password;
	
	@NotNull
	@Size(min=10, max = 12, message="Phone number should have min 10 to max 12 characters")
	private String phone;
	
	private Blob  pic;
	
	@NotNull
	@Size(min=3, max = 200, message="address should have min 50 to max 100 characters")
	private String address;
	
	@NotNull
	private Cart cart;
}
