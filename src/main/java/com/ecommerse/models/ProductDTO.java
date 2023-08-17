package com.ecommerse.models;

import java.sql.Blob;

import com.ecommerse.entities.Category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private int id;
	
	private Category category;
	
	@NotNull
	@Size(min = 3, max = 50, message = "The name should be minimum of 3 letter or maximum of 50 letter")
	private String name;
	
	
	private String description;

	private Blob photo;
	
	@NotNull
	private double price;
	
	@NotNull
	@Size(min = 3, max = 50, message = "The brand should be minimum of 3 letter or maximum of 50 letter")
	private String brand;
	
	
	private String color;
	
	@NotNull
	private int quantity;
	
}
