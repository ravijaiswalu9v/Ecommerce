package com.ecommerse.servicesimpl;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerse.entities.Category;
import com.ecommerse.models.CategoryDTO;
import com.ecommerse.repositories.CategoryRepository;
import com.ecommerse.services.CategoryService;
import com.ecommerse.util.Converter;

@Component
@JavaBean // need info what this is used for
public class CategoryServicesImpl implements CategoryService {

	@Autowired
	Converter converter;
	
	@Autowired
	CategoryRepository categoryRepository;

	public List<CategoryDTO> getAllCategories() {
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		List<Category> categorys= categoryRepository.findAll();
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

	//update a user
	public void UpdateById(int id, Category newCategory) {
		Optional<Category> optional = categoryRepository.findById(id);
		Category category = optional.get();
		category.setId(id);
		category.setTitle(newCategory.getDescription());
		category.setDescription(newCategory.getDescription());
		category.setProduct(newCategory.getProduct());
		categoryRepository.save(category);
	}

}
