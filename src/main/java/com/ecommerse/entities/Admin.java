package com.ecommerse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Admin_id")
	private int id;
	
	//changes here at 12-08-2023
	@Column(name = "Admin_email")
	private String email;
	
	@Column(name = "Admin_password")
	private String password;
	
}
