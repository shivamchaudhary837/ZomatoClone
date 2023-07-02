package com.zomato.service;

import java.util.List;

import com.zomato.model.Category;

public interface CategoryService {

	Category addCategory(Category category);

	List<Category> getAllCategories();
	
}
