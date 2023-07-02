package com.zomato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zomato.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	             
}
