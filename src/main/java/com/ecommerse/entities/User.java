package com.ecommerse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="user_id")
	private int id;
	
	@Column(name="user_name", nullable=false, length = 100)
	private String name;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_password", nullable=false, length =50)
	private String password;
	
	@Column(name="user_phone", nullable=false, length =12)
	private String phone;
	
	@Column(name="user_pic")
	private String  pic;
	
	@Column(name="user_address", nullable=false, length =200)
	private String address;
	
}
