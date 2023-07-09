package com.zomato.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zomato.dto.ProductAddRequest;
import com.zomato.model.Product;
import com.zomato.service.ProductService;
import com.zomato.utility.StorageService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("admin/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StorageService storageService;
	
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
	
	@GetMapping("all")
	public ResponseEntity<?> getAllProducts(){
		
		try {
			List<Product> resProduct=productService.getAllProduct();
			return ResponseEntity.ok(resProduct);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
			}
	}
	
	 @GetMapping(value = "/{productImage}", produces = "image/*")
	 public void fetchProductImage(@PathVariable("productImage") String productImage, HttpServletResponse resp) {
		 
		   System.out.println("Respndfd comfmdf ");
	        try {
	            Resource resource = storageService.load(productImage);
	            
	            if (resource != null) {
	                try (InputStream in = resource.getInputStream()) {
	                    ServletOutputStream out = resp.getOutputStream();
	                    FileCopyUtils.copy(in, out);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	   }
	

}
