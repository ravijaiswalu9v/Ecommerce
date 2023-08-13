package com.ecommerse.servicesimpl;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerse.entities.Product;
import com.ecommerse.repositories.ProductRepository;
import com.ecommerse.services.ProductService;

@Component
@JavaBean // need info what this is used for
public class ProductServicesImpl implements ProductService {

	@Autowired
	ProductRepository repo;

	public List<Product> getAllProducts() {
		List<Product> product = null;

		Iterable<Product> result = repo.findAll();
		product = (List<Product>) result;

//		to view the data on console
//		result.forEach(e -> {
//			System.out.println(e);
//			
//		});

		return product;
	}

	// adding the user
	public Product addProduct(Product u) {
		return repo.save(u);
	}

	public Product getProductByID(int id) {
		Optional<Product> optional = repo.findById(id);
		Product product = optional.get();
		return product;
	}

	public List<Product> addAllProducts(List<Product> products) {
		Iterable<Product> itr = repo.saveAll(products);
		return (List<Product>) itr;
	}

	public void deleteProductById(int id) {
		repo.deleteById(id);
	}

	public void deleteAllProducts() {
		repo.deleteAll();
	}

	//update a user
	public void UpdateById(int id, Product newProduct) {
		Optional<Product> optional = repo.findById(id);
		Product product = optional.get();
		product.setId(id);
		product.setName(newProduct.getName());
		product.setBrand(newProduct.getBrand());
		product.setCategory(newProduct.getCategory());
		product.setColor(newProduct.getColor());
		product.setDescription(newProduct.getDescription());
		product.setPhoto(newProduct.getPhoto());
		product.setPrice(newProduct.getPrice());
		product.setQuantity(newProduct.getQuantity());
		repo.save(product);
	}

}
