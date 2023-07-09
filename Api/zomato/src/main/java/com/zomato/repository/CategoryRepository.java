package com.zomato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zomato.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	             
}
