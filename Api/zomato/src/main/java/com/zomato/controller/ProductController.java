package com.zomato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zomato.dto.ProductAddRequest;
import com.zomato.model.Product;
import com.zomato.service.ProductService;


@RestController
@RequestMapping("admin/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("add")
	public ResponseEntity<?> addProduct(ProductAddRequest productDto) {
		
		try {
		Product resProduct=productService.addProduct(productDto);
		return ResponseEntity.ok(resProduct);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

}
