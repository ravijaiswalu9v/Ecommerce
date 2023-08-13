package com.ecommerse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Login {
	@Id
	@Column(name = "login_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name =  "login_as" , length = 20)// example customer or Admin
	private String role = "customer";
	
	@Column(name = "login_email", length = 50)
	private String email;
	
	@Column(name = "login_password", length = 20)
	private String pasword;
	
}
