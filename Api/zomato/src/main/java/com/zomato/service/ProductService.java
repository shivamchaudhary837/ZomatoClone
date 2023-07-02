package com.zomato.service;

import com.zomato.dto.ProductAddRequest;
import com.zomato.model.Product;

public interface ProductService {

	Product addProduct(ProductAddRequest productDto);

}
