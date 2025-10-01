package com.abhinav.bookskart.catalog.web.controllers;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import com.abhinav.bookskart.catalog.AbstractIT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Sql("/test-data.sql")
public class ProductControllerTest extends AbstractIT {

	@Test
	void shouldReturnProducts() {
		RestAssured.given().contentType(ContentType.JSON).when().get("/api/products").then().statusCode(200)
				.body("data", Matchers.hasSize(10)).body("totalElements", is(15)).body("pageNumber", is(1))
				.body("totalPages", is(2)).body("isFirst", is(true)).body("isLast", is(false)).body("hasNext", is(true))
				.body("hasPrevious", is(false));

	}

}
