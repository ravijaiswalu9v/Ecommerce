package com.ecommerse.entities;

import java.sql.Blob;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int id;
	
	@Column(name="customer_name", length = 50)
	private String name;
	
	@Column(name="customer_email")
	private String email;
	
	@Column(name="customer_password", length =50)
	private String password;
	
	@Column(name="customer_phone",  length =12)
	private String phone;
	
	@Column(name="customer_pic" )
	private Blob  pic;
	
	@Column(name="customer_address",  length =200)
	private String address;
	
	//one customer have one cart
	@OneToOne(cascade = CascadeType.PERSIST)
	private Cart cart;
}
