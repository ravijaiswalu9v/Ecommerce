////package com.ecommerse.controllers;
////
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.DeleteMapping;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PathVariable;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PutMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RestController;
////
////import com.ecommerse.entities.Product;
////import com.ecommerse.services.ProductService;
////
////@RestController
////public class ProductController {
////	
////	@Autowired
////	ProductService productService;
////
//////---------------------------------------------------------
////	
////	//Read all the products
////	@GetMapping("/products")
////	public ResponseEntity <List<Product>> getAllProducts(){
////		List<Product> products = productService.getAllProducts();
////		if(products.size()!=0) {
////			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
////		}
////		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
////	}
////	
////	
////	// get a product by specific id
////	@GetMapping("/products/{id}")
////	public Product getProductById(@PathVariable int id) {
////		return productService.getProductByID(id);
////	}
////	
////	//new product
////	// post mapping(create) the data(products)
////	@PostMapping("/product")
////	public Product addProduct(@RequestBody Product product) {
////		Product u = productService.addProduct(product);
////		return u;
////	}
////	
////	@PostMapping("/products")
////	public List<Product> addAllProduct(@RequestBody List<Product> products){
////		return productService.addAllProducts(products);
////	}
////	
////	//Delete a product
////	@DeleteMapping("/products/{id}")
////	public void deleteProductById(@PathVariable int id) {
////		productService.deleteProductById(id);
////	}
////	
////	//Delete all products
////	@DeleteMapping("/products")
////	public void deleteAllProducts() {
////		productService.deleteAllProducts();
////	}
////	
////	//Update product
////	@PutMapping("/products/{id}")
////	public void UpdateById(@PathVariable("id") int uid, @RequestBody Product newProduct) {
////		productService.UpdateById(uid,newProduct);
////	}
////}
//
//package com.ecommerse.controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ecommerse.entities.Product;
//import com.ecommerse.models.ProductDTO;
//import com.ecommerse.services.ProductService;
//import com.ecommerse.util.Converter;
//
//import jakarta.validation.Valid;
//
//@RestController
//public class ProductController {
//	
//	@Autowired
//	ProductService productService;
//	
//	@Autowired
//	Converter converter;
//
//	
//	//Read all the Products
//	@GetMapping("/product")
//	public ResponseEntity<List<ProductDTO>> getAllProduct(){
//		List<ProductDTO> allProduct = productService.getAllProducts();
//		if(allProduct.size()!=0)
//		return new ResponseEntity<List<ProductDTO>>(allProduct,HttpStatus.OK);
//		return new ResponseEntity<List<ProductDTO>>(HttpStatus.NOT_FOUND);
//	}
//	
//	
//	// get a Product by specific id
//	@GetMapping("/product/{id}")
//	public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
//		ProductDTO ProductDTO = productService.getProductByID(id);
//		if (ProductDTO!=null) {
//			return new ResponseEntity<ProductDTO>(ProductDTO,HttpStatus.OK );
//		}
//		return new ResponseEntity<ProductDTO>(ProductDTO,HttpStatus.NOT_FOUND);
//	}
//	
//	//new Product
//	// post mapping(create) the data(Products)
//	@PostMapping("/product")
//	public ProductDTO addProduct(@Valid @RequestBody ProductDTO ProductDTO) {
//		Product Product = converter.covertToProductEntity(ProductDTO);
//		return productService.addProduct(Product);
//	}
//	
//	@PostMapping("/products")
//	public List<ProductDTO> addAllProduct(@RequestBody List<ProductDTO> ProductsDtos){
//		List<Product> Products = new ArrayList<>();
//		for (ProductDTO cDTO :ProductsDtos ) {
//			Products.add(converter.covertToProductEntity(cDTO));
//		}
//		return productService.addAllProducts(Products);
//	}
//	
//	//Delete a Product
//	@DeleteMapping("/product/{id}")
//	public void deleteById(@PathVariable int id) {
//		productService.deleteProductById(id);
//	}
//	
//	//Delete all Products
//	@DeleteMapping("/product")
//	public void deleteAllProducts() {
//		productService.deleteAllProducts();
//	}
//	
//	//Update Product
//	@PutMapping("/product/{id}")
//	public void UpdateById(@PathVariable("id") int uid,@Valid @RequestBody Product newProduct) {
//		productService.UpdateById(uid,newProduct);
//	}
//}
//
