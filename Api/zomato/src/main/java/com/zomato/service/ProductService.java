package com.zomato.service;

import java.util.List;

import com.zomato.dto.ProductAddRequest;
import com.zomato.model.Product;

public interface ProductService {

	Product addProduct(ProductAddRequest productDto);

	List<Product> getAllProduct();

}
