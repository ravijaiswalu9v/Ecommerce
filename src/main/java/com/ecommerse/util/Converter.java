package com.ecommerse.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ecommerse.entities.Customer;
import com.ecommerse.models.CustomerDTO;

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
	
}
