package com.ecommerse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerse.entities.Admin;
import com.ecommerse.entities.Category;
import com.ecommerse.entities.Product;
import com.ecommerse.models.AdminDTO;
import com.ecommerse.models.CategoryDTO;
import com.ecommerse.models.CustomerDTO;
import com.ecommerse.models.ProductDTO;
import com.ecommerse.services.AdminService;
import com.ecommerse.util.Converter;

import jakarta.validation.Valid;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

//	@Autowired
//	CustomerService customerService;

//	@Autowired
//	ProductService productService;
//
//	@Autowired
//	CategoryService categoryService;

	@Autowired
	Converter converter;

//Admin ---------------------------------------------------------

	// view admin details
	@GetMapping("ecommerce/admin/{id}")
	public ResponseEntity<List<AdminDTO>> viewAdminDetails() {
		final List<AdminDTO> adminDTO = adminService.viewAdminDetails();
		if (adminDTO.size() != 0)
			return new ResponseEntity<List<AdminDTO>>(adminDTO, HttpStatus.OK);
		return new ResponseEntity<List<AdminDTO>>(HttpStatus.NOT_FOUND);
	}

	// update admin details
	@PutMapping("ecommerce/admin/{id}")
	public void updateAdminDetails(@PathVariable("id") int aid, @Valid @RequestBody Admin newAdmin) {
		adminService.updateAdminDetails(aid, newAdmin);
	}

	// Customer Handler ---------------------------------------------------
	// Read all the customers
	@GetMapping("/admin/customer")
	public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
		List<CustomerDTO> allCustomer = adminService.getAllCustomer();
		if (allCustomer.size() != 0)
			return new ResponseEntity<List<CustomerDTO>>(allCustomer, HttpStatus.OK);
		return new ResponseEntity<List<CustomerDTO>>(HttpStatus.NOT_FOUND);
	}

	// get a customer by specific id
	@GetMapping("/admin/customer/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
		CustomerDTO customerDTO = adminService.getCustomerByID(id);
		if (customerDTO != null) {
			return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
		}
		return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.NOT_FOUND);
	}

	// Delete a customer
	@DeleteMapping("admin/customer/{id}")
	public String deleteById(@PathVariable int id) {
		return adminService.deleteCustomerById(id);
	}

	// Delete all customers
	@DeleteMapping("admin/customer/danger")
	public void deleteAllCustomers() {
		adminService.deleteAllCustomers();
	}

	// products handler----------------------------------------------

	// Read all the Products
	@GetMapping("/admin/product")
	public ResponseEntity<List<ProductDTO>> getAllProduct() {
		List<ProductDTO> allProduct = adminService.getAllProducts();
		if (allProduct.size() != 0)
			return new ResponseEntity<List<ProductDTO>>(allProduct, HttpStatus.OK);
		return new ResponseEntity<List<ProductDTO>>(HttpStatus.NOT_FOUND);
	}

	// get a Product by specific id
	@GetMapping("/admin/product/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
		ProductDTO ProductDTO = adminService.getProductByID(id);
		if (ProductDTO != null) {
			return new ResponseEntity<ProductDTO>(ProductDTO, HttpStatus.OK);
		}
		return new ResponseEntity<ProductDTO>(ProductDTO, HttpStatus.NOT_FOUND);
	}

	// new Product
	// post mapping(create) the data(Products)
	@PostMapping("/admin/product")
	public ProductDTO addProduct(@Valid @RequestBody ProductDTO ProductDTO) {
		Product Product = converter.covertToProductEntity(ProductDTO);
		return adminService.addProduct(Product);
	}

	// Delete a Product
	@DeleteMapping("/admin/product/{id}")
	public void deleteProductById(@PathVariable int id) {
		adminService.deleteProductById(id);
	}

	// Update Product
	@PutMapping("/admin/product/{id}")
	public void UpdateById(@PathVariable("id") int uid, @Valid @RequestBody Product newProduct) {
		adminService.UpdateProductById(uid, newProduct);
	}

	// category handler----------------------------------------------
	// Read all the Categories
	@GetMapping("/admin/category")
	public ResponseEntity<List<CategoryDTO>> getAllCategory() {
		List<CategoryDTO> allCategory = adminService.getAllCategories();
		if (allCategory.size() != 0)
			return new ResponseEntity<List<CategoryDTO>>(allCategory, HttpStatus.OK);
		return new ResponseEntity<List<CategoryDTO>>(HttpStatus.NOT_FOUND);
	}

	// get a Category by specific id
	@GetMapping("/admin/category/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable int id) {
		CategoryDTO CategoryDTO = adminService.getCategoryByID(id);
		if (CategoryDTO != null) {
			return new ResponseEntity<CategoryDTO>(CategoryDTO, HttpStatus.OK);
		}
		return new ResponseEntity<CategoryDTO>(CategoryDTO, HttpStatus.NOT_FOUND);
	}

	// new Category
	// post mapping(create) the data(Categories)
	@PostMapping("/admin/category")
	public CategoryDTO addCategory(@Valid @RequestBody CategoryDTO CategoryDTO) {
		Category Category = converter.covertToCategoryEntity(CategoryDTO);
		return adminService.addCategory(Category);
	}

	// Delete a Category
	@DeleteMapping("/admin/category/{id}")
	public void deleteCategoryById(@PathVariable int id) {
		adminService.deleteCategoryById(id);
	}

	// Update Category
	@PutMapping("/admin/category/{id}")
	public void UpdateById(@PathVariable("id") int uid, @Valid @RequestBody Category newCategory) {
		adminService.UpdateCategoryById(uid, newCategory);
	}

	// Update Category
	@PostMapping("/admin/putProductInCategory/{cust_id}/{pro_id}")
	public String putProductInCategory(@PathVariable("cust_id") int catdegoryId, @PathVariable("pro_id") int productID) {
		return adminService.putProductInCategory(catdegoryId, productID);
	}

}
