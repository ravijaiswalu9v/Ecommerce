package com.ecommerse.models;

import java.util.List;

import com.ecommerse.entities.Product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDTO {

	private int id;
	
	@NotNull
	@Size(min = 3, max = 50, message = "The name should be minimum of 3 letter or maximum of 50 letter")
	private String title;
	
	@NotNull
	@Size(min = 3, max = 200, message = "The name should be minimum of 3 letter or maximum of 50 letter")	
	private String description;

	
	private List<Product> product;
	
	
}
