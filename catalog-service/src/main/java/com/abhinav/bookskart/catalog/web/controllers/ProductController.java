package com.abhinav.bookskart.catalog.web.controllers;

import com.abhinav.bookskart.catalog.domain.PagedResult;
import com.abhinav.bookskart.catalog.domain.Product;
import com.abhinav.bookskart.catalog.domain.ProductNotFoundException;
import com.abhinav.bookskart.catalog.domain.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/{code}")
	ResponseEntity<Product> getProductByCode(@PathVariable String code) {
		return productService.getProductByCode(code).map(ResponseEntity::ok)
				.orElseThrow(() -> ProductNotFoundException.forCode(code));
	}
}
