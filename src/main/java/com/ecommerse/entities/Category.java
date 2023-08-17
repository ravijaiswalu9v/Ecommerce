package com.ecommerse.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int id;
	
	@Column(name = "category_title", length = 100)
	private String title;
	
	@Column(name = "category_desc", length = 1500)
	private String description;
	
	@OneToMany(mappedBy = "category" ,cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties
	private List<Product> product;
	
}
