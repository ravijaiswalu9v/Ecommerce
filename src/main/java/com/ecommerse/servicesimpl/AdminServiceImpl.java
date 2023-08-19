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
