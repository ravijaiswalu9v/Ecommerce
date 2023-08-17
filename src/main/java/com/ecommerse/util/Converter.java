package com.ecommerse.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ecommerse.entities.Category;
import com.ecommerse.entities.Customer;
import com.ecommerse.entities.Product;
import com.ecommerse.models.CategoryDTO;
import com.ecommerse.models.CustomerDTO;
import com.ecommerse.models.ProductDTO;

@Component
public class Converter {
	//convert cutomerEntity to customerDTO
	public CustomerDTO convertToCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		if(customer!=null) {
//			customerDTO.setName(customer.getName());
//			customerDTO.setAddress(customer.getAddress());
//			customerDTO.setEmail(customer.getEmail());
//			customerDTO.setId(customer.getId());
//			customerDTO.setPassword(customer.getPassword());
//			customerDTO.setPhone(customer.getPhone());
//			customerDTO.setPic(customer.getPic());
			
			BeanUtils.copyProperties(customer, customerDTO);
		}
		return customerDTO;
	}
	
	//convert CustomerDTO to Entity
	public Customer covertToCustomerEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		if(customerDTO!=null)
			BeanUtils.copyProperties(customerDTO, customer);
		return customer;
	}
	
	//convert ProductEntity to ProductDTO
	public ProductDTO convertToProductDTO(Product product) {
			ProductDTO productDTO = new ProductDTO();
			if(product!=null) {
				BeanUtils.copyProperties(product, productDTO);
			}
			return productDTO;
		}
		
		//convert ProductDTO to product Entity
		public Product covertToProductEntity(ProductDTO productDTO) {
			Product product = new Product();
			if(productDTO!=null)
				BeanUtils.copyProperties(productDTO, product);
			return product;
		}
		
		//convert ProductEntity to PrCategoryO
				public CategoryDTO convertToCategoryDTO(Category category) {
					CategoryDTO categoryDTO = new CategoryDTO();
					if(category!=null) {
						BeanUtils.copyProperties(category, categoryDTO);
					}
					return categoryDTO;
				}
				
				//convert CategoryDTO to category Entity
				public Category covertToCategoryEntity(CategoryDTO categoryDTO) {
					Category category = new Category();
					if(categoryDTO!=null)
						BeanUtils.copyProperties(categoryDTO, category);
					return category;
				}
	
}
