package com.ecommerse.entities;

import java.sql.Blob;

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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="customer_id")
	private int id;
	
	@Column(name="customer_name", nullable=false, length = 100)
	private String name;
	
	@Column(name="customer_email")
	private String email;
	
	@Column(name="customer_password", nullable=false, length =50)
	private String password;
	
	@Column(name="customer_phone", nullable=false, length =12)
	private String phone;
	
	@Column(name="customer_pic", nullable = true)
	private Blob  pic;
	
	@Column(name="customer_address", nullable=false, length =200)
	private String address;
}
