package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Product;
import com.ecommerse.models.ProductDTO;

public interface ProductService {
	public List<ProductDTO> getAllProducts();
	public ProductDTO addProduct(Product product);
	public ProductDTO getProductByID(int id);
	public void deleteProductById(int id);
	public void UpdateProductById(int id, Product existingProduct);
}
