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
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "category_id")
	private String category;
	
	@Column(name = "product_name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "product_desc", length = 1500, nullable = false)
	private String description;

	@Column(name = "product_photo", nullable = true)
	private Blob photo;
	
	@Column(name = "product_price",length = 120, nullable = false)
	private double price;
	
	@Column(name = "product_brand", nullable = false)
	private String brand;
	
	@Column(name = "product_color", length = 1500, nullable = false)
	private int color;
	
}
