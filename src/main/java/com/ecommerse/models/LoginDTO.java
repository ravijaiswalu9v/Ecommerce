package com.ecommerse.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {
	
	private int id;
	
	private String role = "customer";
	
	private String email;
	
	private String pasword;
	
}
