package com.ecommerse.entities;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="order_id")
	private int id;
	
	@Column(name="customer_id", nullable=false, length = 100)
	private String customer;
	
	@Column(name="order_name")
	private String name;
	
	@Column(name="order_address", nullable=false, length =50)
	private String address;
	
	@Column(name="order_city", nullable=false, length =12)
	private String city;
	
	@Column(name="order_state", nullable = true)
	private String state;
	
	@Column(name="order_zipcode", nullable=false, length =200)
	private int zipcode;
	
	@Column(name="order_contact", nullable=false, length =200)
	private int contact;
}
