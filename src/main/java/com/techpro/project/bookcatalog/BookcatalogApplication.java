package com.techpro.project.bookcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BookCatalogApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookCatalogApplication.class, args);
	}
}
