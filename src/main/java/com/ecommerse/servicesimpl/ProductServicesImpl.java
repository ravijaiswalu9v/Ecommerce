//package com.ecommerse.servicesimpl;
//
//import java.beans.JavaBean;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ecommerse.entities.Product;
//import com.ecommerse.models.ProductDTO;
//import com.ecommerse.repositories.ProductRepository;
//import com.ecommerse.services.ProductService;
//import com.ecommerse.util.Converter;
//
//@Component
//@JavaBean // need info what this is used for
//public class ProductServicesImpl implements ProductService {
//
//	@Autowired
//	Converter converter;
//	
//	@Autowired
//	ProductRepository productRepository;
//
//	public List<ProductDTO> getAllProducts() {
//		List<ProductDTO> productDTOs = new ArrayList<>();
//		List<Product> products= productRepository.findAll();
//		for (Product p : products) {
//			productDTOs.add(converter.convertToProductDTO(p));
//		}
//		return productDTOs;
//	}
//
//	// adding the user
//	public ProductDTO addProduct(Product u) {
//		final Product product = productRepository.save(u);
//		return converter.convertToProductDTO(product);
//	}
//
//	public ProductDTO getProductByID(int id) {
//		Product product = productRepository.findById(id).get();
//		return converter.convertToProductDTO(product);
//	}
//
//	public List<ProductDTO> addAllProducts(List<Product> products) {
//		List<Product> product = productRepository.saveAll(products);
//		List<ProductDTO> productDTOs = new ArrayList<>();
//		for (Product p : product) {
//			productDTOs.add(converter.convertToProductDTO(p));
//		}
//		return productDTOs;
//	}
//
//	public void deleteProductById(int id) {
//		productRepository.deleteById(id);
//	}
//
//	public void deleteAllProducts() {
//		productRepository.deleteAll();
//	}
//
//	//update a user
//	public void UpdateById(int id, Product newProduct) {
//		Optional<Product> optional = productRepository.findById(id);
//		Product product = optional.get();
//		product.setId(id);
//		product.setName(newProduct.getName());
//		product.setBrand(newProduct.getBrand());
//		product.setCategory(newProduct.getCategory());
//		product.setColor(newProduct.getColor());
//		product.setDescription(newProduct.getDescription());
//		product.setPhoto(newProduct.getPhoto());
//		product.setPrice(newProduct.getPrice());
//		product.setQuantity(newProduct.getQuantity());
//		productRepository.save(product);
//	}
//
//}
