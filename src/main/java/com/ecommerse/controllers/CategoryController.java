//package com.ecommerse.controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ecommerse.entities.Category;
//import com.ecommerse.models.CategoryDTO;
//import com.ecommerse.services.CategoryService;
//import com.ecommerse.servicesimpl.CategoryServicesImpl;
//import com.ecommerse.util.Converter;
//
//import jakarta.validation.Valid;
//import lombok.val;
//
//@RestController
//public class CategoryController {
//	
//	@Autowired
//	CategoryService categoryService;
//	
//	@Autowired
//	Converter converter;
//	
//	
//	//Read all the Categories
//	@GetMapping("/category")
//	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
//		List<CategoryDTO> allCategory = categoryService.getAllCategories();
//		if(allCategory.size()!=0)
//		return new ResponseEntity<List<CategoryDTO>>(allCategory,HttpStatus.OK);
//		return new ResponseEntity<List<CategoryDTO>>(HttpStatus.NOT_FOUND);
//	}
//	
//	
//	// get a Category by specific id
//	@GetMapping("/category/{id}")
//	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable int id) {
//		CategoryDTO CategoryDTO = categoryService.getCategoryByID(id);
//		if (CategoryDTO!=null) {
//			return new ResponseEntity<CategoryDTO>(CategoryDTO,HttpStatus.OK );
//		}
//		return new ResponseEntity<CategoryDTO>(CategoryDTO,HttpStatus.NOT_FOUND);
//	}
//	
//	//new Category
//	// post mapping(create) the data(Categories)
//	@PostMapping("/category")
//	public CategoryDTO addCategory(@Valid @RequestBody CategoryDTO CategoryDTO) {
//		Category Category = converter.covertToCategoryEntity(CategoryDTO);
//		return categoryService.addCategory(Category);
//	}
//	
//	@PostMapping("/categories")
//	public List<CategoryDTO> addAllCategory(@RequestBody List<CategoryDTO> CategorysDtos){
//		List<Category> Categorys = new ArrayList<>();
//		for (CategoryDTO cDTO :CategorysDtos ) {
//			Categorys.add(converter.covertToCategoryEntity(cDTO));
//		}
//		return categoryService.getAllCategories();
//	}
//	
//	//Delete a Category
//	@DeleteMapping("/category/{id}")
//	public void deleteById(@PathVariable int id) {
//		categoryService.deleteCategoryById(id);
//	}
//	
//	
//	//Update Category
//	@PutMapping("/category/{id}")
//	public void UpdateById(@PathVariable("id") int uid,@Valid @RequestBody Category newCategory) {
//		categoryService.UpdateById(uid,newCategory);
//	}
//}
