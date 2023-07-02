package com.zomato.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.zomato.dto.ProductAddRequest;
import com.zomato.model.Category;
import com.zomato.model.Product;
import com.zomato.repository.CategoryRepository;
import com.zomato.repository.ProductRepository;
import com.zomato.utility.StorageService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StorageService storageService;
	
	@Override
	public Product addProduct(ProductAddRequest productDto) {
		// TODO Auto-generated method stub
		
		Product product=ProductAddRequest.toEntity(productDto);
		
		Optional<Category> optional = categoryRepository.findById(productDto.getCategoryId());
		Category category = null;
		
		if(optional.isPresent()) {
			category = optional.get();
		}
		
		product.setCategory(category);
		MultipartFile productImmage=productDto.getImage();
		
		String productImageName = storageService.store(productImmage);
		product.setProductImage(productImageName);
		productRepository.save(product);
		
		return product;
	}
}
