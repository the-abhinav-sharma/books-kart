package com.abhinav.bookskart.catalog;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import io.restassured.RestAssured;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.BeforeEach;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
public class AbstractIT {
	@LocalServerPort
	int port;
	
	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}
	

}
