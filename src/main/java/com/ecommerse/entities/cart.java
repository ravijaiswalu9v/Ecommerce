package com.ecommerse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "category_id")
	private int id;
	
	@Column(name = "category_title", length = 100, nullable = false)
	private String title;
	
	@Column(name = "category_desc", length = 1500, nullable = false)
	private String description;
}
