package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product addProduct(Product product);
	public Product getProductByID(int id);
	public void deleteProductById(int id);
	public void deleteAllProducts();
	public void UpdateById(int id, Product existingProduct);
	public List<Product> addAllProducts(List<Product> products);
}
