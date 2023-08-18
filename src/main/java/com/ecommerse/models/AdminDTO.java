package com.ecommerse.models;

import java.sql.Blob;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminDTO{

	private int id;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 6, max = 50, message = "password must be in between 6 to 50 character")
	private String password;
	
	private String name;
	
	private Blob pic;
	@Size(min = 10, max = 12, message = "phone number between 10 to 12 will be accepted only")
	private String phone;
}
