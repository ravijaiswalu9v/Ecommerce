package com.ecommerse.servicesimpl;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerse.entities.Admin;
import com.ecommerse.entities.Category;
import com.ecommerse.entities.Customer;
import com.ecommerse.entities.Product;
import com.ecommerse.models.AdminDTO;
import com.ecommerse.models.CategoryDTO;
import com.ecommerse.models.CustomerDTO;
import com.ecommerse.models.ProductDTO;
import com.ecommerse.repositories.AdminRepository;
import com.ecommerse.repositories.CategoryRepository;
import com.ecommerse.repositories.CustomerRepository;
import com.ecommerse.repositories.ProductRepository;
import com.ecommerse.services.AdminService;
import com.ecommerse.services.CustomerService;
import com.ecommerse.util.Converter;

@Component
@JavaBean // need info what this is used for
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	Converter converter;

	// Admin can view their details
	public List<AdminDTO> viewAdminDetails() {
		List<Admin> admin = adminRepository.findAll();
		List<AdminDTO> adminDTOs = new ArrayList<>();
		for (Admin a : admin) {
			adminDTOs.add(converter.convertToAdminDTO(a));
		}
		return adminDTOs;
	}

	// Admin can update their details
	@Override
	public void updateAdminDetails(int id, Admin newAdmin) {
		Admin admin = adminRepository.findById(id).get();
		admin.setId(id);
		admin.setName(newAdmin.getName());
		admin.setEmail(newAdmin.getEmail());
		admin.setPassword(newAdmin.getPassword());
		admin.setPhone(newAdmin.getPhone());
		admin.setPic(newAdmin.getPic());
		adminRepository.save(admin);

	}

	// customers-------------------------------------------------------
	// Admin can see all the customers
	public List<CustomerDTO> getAllCustomer() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customerDTOs = new ArrayList<>();

		for (Customer c : customers) {
			customerDTOs.add(converter.convertToCustomerDTO(c));
		}
		return customerDTOs;
	}

	// Admin can see customers one by one
	public CustomerDTO getCustomerByID(int id) {
		Customer customer = customerRepository.findById(id).get();
		return converter.convertToCustomerDTO(customer);
	}

	// Admin can remove the customer
	public String deleteCustomerById(int id) {
		customerRepository.deleteById(id);
		return "The customer of ID:" + id + " has been deleted Successfully!..";
	}

	// Admin can remove all existing customers
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}

	// -----------------------------------------------------------products
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<Product> products = productRepository.findAll();
		for (Product p : products) {
			productDTOs.add(converter.convertToProductDTO(p));
		}
		return productDTOs;
	}

	// adding the user
	public ProductDTO addProduct(Product u) {
		final Product product = productRepository.save(u);
		return converter.convertToProductDTO(product);
	}

	public ProductDTO getProductByID(int id) {
		Product product = productRepository.findById(id).get();
		return converter.convertToProductDTO(product);
	}

	public List<ProductDTO> addAllProducts(List<Product> products) {
		List<Product> product = productRepository.saveAll(products);
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Product p : product) {
			productDTOs.add(converter.convertToProductDTO(p));
		}
		return productDTOs;
	}

	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}

	// update a user
	public void UpdateProductById(int id, Product existingProduct) {
		Optional<Product> optional = productRepository.findById(id);
		Product product = optional.get();
		product.setId(id);
		product.setName(existingProduct.getName());
		product.setBrand(existingProduct.getBrand());
		product.setCategory(existingProduct.getCategory());
		product.setColor(existingProduct.getColor());
		product.setDescription(existingProduct.getDescription());
		product.setPhoto(existingProduct.getPhoto());
		product.setPrice(existingProduct.getPrice());
		product.setQuantity(existingProduct.getQuantity());
		productRepository.save(product);
	}

	// ------------------------------------------------------------categories
	public List<CategoryDTO> getAllCategories() {
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		List<Category> categorys = categoryRepository.findAll();
		for (Category p : categorys) {
			categoryDTOs.add(converter.convertToCategoryDTO(p));
		}
		return categoryDTOs;
	}

	// adding the user
	public CategoryDTO addCategory(Category u) {
		final Category category = categoryRepository.save(u);
		return converter.convertToCategoryDTO(category);
	}

	public CategoryDTO getCategoryByID(int id) {
		Category category = categoryRepository.findById(id).get();
		return converter.convertToCategoryDTO(category);
	}

	public List<CategoryDTO> addAllCategorys(List<Category> categorys) {
		List<Category> category = categoryRepository.saveAll(categorys);
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for (Category p : category) {
			categoryDTOs.add(converter.convertToCategoryDTO(p));
		}
		return categoryDTOs;
	}

	public void deleteCategoryById(int id) {
		categoryRepository.deleteById(id);
	}

	public void deleteAllCategorys() {
		categoryRepository.deleteAll();
	}

	// update a user
	public void UpdateCategoryById(int id, Category newCategory) {
		Optional<Category> optional = categoryRepository.findById(id);
		Category category = optional.get();
		category.setId(id);
		category.setTitle(newCategory.getDescription());
		category.setDescription(newCategory.getDescription());
		category.setProduct(newCategory.getProduct());
		categoryRepository.save(category);
	}

	@Override
	public String putProductInCategory(int categoryId, int productId) {
		//let the admin gave correct details, means id present in databases
		Category category = categoryRepository.findById(categoryId).get();
		Product product = productRepository.findById(productId).get();
		
		//category have many products so..
		List<Product> productsList = new ArrayList<>();
		productsList.add(product);
		
		//assign product to category
		category.setProduct(productsList);
		
		//assign category to product
		product.setCategory(category);
		
		categoryRepository.save(category);
		
//		product.setCategory(category);
//		productRepository.save(product);
		
		return "product linked with category, Successfully";
	}

	

}
