package com.ecommerse.entities;

import java.sql.Blob;

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
	
	
	//required for login  begin------>
	@Column(name = "Admin_email")
	private String email;
	
	@Column(name = "Admin_password")
	private String password;
	//required for login  end ------>
	
	//some extra info admin can set
	@Column(name = "admin_name", length = 50)
	private String name;
	
	@Column(name = "admin_pic")
	private Blob pic;
	
	@Column(name = "admin_phone", length = 15)
	private String phone;
}
