package com.techpro.project.bookcatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is responsible for handling the root endpoint of the API.
 * It provides a welcome message and a list of available endpoints.
 * It also provides information about the project and the developer.
 */
@RestController
public class HomeController {

  @GetMapping("/")
  public Map<String, Object> welcome() {
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("message",
        "Welcome to the Book Catalog API. Here are the available endpoints and their functionalities:");

    Map<String, String> endpoints = new LinkedHashMap<>();
    endpoints.put("GET: /", "Welcome message");
    endpoints.put("GET /books", "Retrieve all books");
    endpoints.put("GET /books/{id}", "Retrieve a book by its ID");
    endpoints.put("POST /books/add", "Add a new book");
    endpoints.put("POST /books", "Add multiple new books");
    endpoints.put("PUT /books/{id}", "Update an existing book by ID");
    endpoints.put("DELETE /books/{id}", "Delete a book by ID");
    endpoints.put("DELETE /books", "Delete all books");
    endpoints.put("GET /books/published", "Find books by published status");
    endpoints.put("GET /books/author", "Find books by author");
    endpoints.put("GET /books/title", "Find books by title");
    endpoints.put("GET /books/genre", "Find books by genre");

    response.put("endpoints", endpoints);

    Map<String, String> project = new LinkedHashMap<>();
    project.put("Project Name", "Book Catalog API");
    project.put("Data", "Initial data on the h2 in-memory database are provided at initialization.");
    project.put("Swagger", "http://localhost:8080/swagger-ui/index.html#/");

    response.put("project", project);

    Map<String, String> info = new LinkedHashMap<>();
    info.put("Version", "1.0");
    info.put("Last Update", "2024-07-07");
    info.put("Notice", "This API is for educational and project based purposes only.");
    info.put("Contact", "vasileios.vasileiadis@techproacademy.com");
    info.put("Developer", "Vasileios Vasileiadis");

    response.put("info", info);

    return response;
  }
}
