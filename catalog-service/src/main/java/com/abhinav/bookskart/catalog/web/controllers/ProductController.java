package com.abhinav.bookskart.catalog.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.bookskart.catalog.domain.PagedResult;
import com.abhinav.bookskart.catalog.domain.Product;
import com.abhinav.bookskart.catalog.domain.ProductService;

@RestController
@RequestMapping("/api/products")
class ProductController {
	
	private final ProductService productService;
	
	ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
		return productService.getProducts(pageNo);
	}

}
