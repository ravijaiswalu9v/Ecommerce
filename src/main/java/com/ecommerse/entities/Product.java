package com.ecommerse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "product_title", length = 100, nullable = false)
	private String title;
	
	@Column(name = "product_desc", length = 1500, nullable = false)
	private String description;

	@Column(name = "product_photo", nullable = false)
	private String photo;
	
	@Column(name = "product_price",length = 120, nullable = false)
	private double price;
	
	@Column(name = "product_discount", nullable = false)
	private int discount;
	
	@Column(name = "product_quantity", length = 1500, nullable = false)
	private int quantity;
	
}
