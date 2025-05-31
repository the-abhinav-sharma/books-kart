package com.abhinav.bookskart.catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontController {

	@GetMapping("/health")
	public String health() {
		return "Catalog-Service is up and running";
		
	}
}
