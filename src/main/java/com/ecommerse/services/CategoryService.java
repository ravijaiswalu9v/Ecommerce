package com.ecommerse.services;

import java.util.List;

import com.ecommerse.entities.Category;

public interface CategoryService {
	public List<Category> getAllCategories();
	public Category addCategory(Category category);
	public Category getCategoryByID(int id);
	public void deleteCategoryById(int id);
	public void deleteAllCategories();
	public void UpdateById(int id, Category existingCategory);
}
