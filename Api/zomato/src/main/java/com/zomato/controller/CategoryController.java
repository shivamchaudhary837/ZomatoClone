package com.zomato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zomato.model.Category;
import com.zomato.service.CategoryService;

@RestController
@RequestMapping("admin/category/")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    
	@Autowired
	private  CategoryService categoryService;
	
	@PostMapping("add")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        
        Category addedCategory = categoryService.addCategory(category);
        
        if (addedCategory != null) {
            return ResponseEntity.ok(addedCategory);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	    @GetMapping("all")
	    public ResponseEntity<?> getAllCategories() {
	        
	    	try {
	        List<Category> categories = categoryService.getAllCategories();
	        System.out.println("Response sent");
	        return ResponseEntity.ok(categories);
	    	}catch (Exception e) {
				// TODO: handle exception
	    		e.printStackTrace();
	    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	    }
}
