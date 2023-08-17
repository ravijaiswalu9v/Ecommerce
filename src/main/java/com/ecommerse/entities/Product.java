package com.ecommerse.entities;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "product_name", length = 100 )
	private String name;
	
	@Column(name = "product_desc", length = 1500)
	private String description;

	@Column(name = "product_photo")
	private Blob photo;
	
	@Column(name = "product_price",length = 120)
	private double price;
	
	@Column(name = "product_brand")
	private String brand;
	
	@Column(name = "product_color", length = 1500)
	private String color;
	
	@Column(name = "product_quantity")
	private int quantity;
	
	@JoinColumn(name = "cat_id")
	@JsonIgnoreProperties
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Category category;
	
}
