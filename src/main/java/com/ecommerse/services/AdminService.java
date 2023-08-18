 package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Admin;
import com.ecommerse.entities.Category;
import com.ecommerse.entities.Product;
import com.ecommerse.models.AdminDTO;
import com.ecommerse.models.CategoryDTO;
import com.ecommerse.models.CustomerDTO;
import com.ecommerse.models.ProductDTO;

public interface AdminService {
	
	//Admin manipulates their details
	public List<AdminDTO> viewAdminDetails();// for this I have to make new repository function as Admin can be only one so what is the need to search them by id search directly
	public void updateAdminDetails(int id, Admin newAdmin);
	
	//Admin manipulates customers
	public List<CustomerDTO> getAllCustomer();
	public CustomerDTO getCustomerByID(int id);
	public String deleteCustomerById(int id);
	public void deleteAllCustomers();
	
	//Admin manipulate products
	public List<ProductDTO> getAllProducts();
	public ProductDTO addProduct(Product product);
	public ProductDTO getProductByID(int id);
	public void deleteProductById(int id);
	public void UpdateProductById(int id, Product existingProduct);
	
	//Admin can manipulate Categories
	public List<CategoryDTO> getAllCategories();
	public CategoryDTO addCategory(Category category);
	public CategoryDTO getCategoryByID(int id);
	public void deleteCategoryById(int id);
	public void UpdateCategoryById(int id, Category existingCategory);
	
	//@Admin can keep product into category
	public String putProductInCategory(int categoryId, int ProductId);
	
}
