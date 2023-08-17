package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Category;
import com.ecommerse.models.CategoryDTO;

public interface CategoryService {
	public List<CategoryDTO> getAllCategories();
	public CategoryDTO addCategory(Category category);
	public CategoryDTO getCategoryByID(int id);
	public void deleteCategoryById(int id);
	public void UpdateById(int id, Category existingCategory);
}
