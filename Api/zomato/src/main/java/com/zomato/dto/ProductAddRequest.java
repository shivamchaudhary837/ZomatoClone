package com.zomato.dto;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.zomato.model.Product;

public class ProductAddRequest {
	
	private Integer id;
    private String title;
	private String description;
	private Double rating;
    private Integer price;
    private Integer categoryId;
    private MultipartFile image;
    
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public static Product toEntity(ProductAddRequest dto) {
		Product entity=new Product();
		BeanUtils.copyProperties(dto, entity, "image", "categoryId");		
		return entity;
	}
	
}

