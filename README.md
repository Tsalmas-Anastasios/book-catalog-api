# Book Catalog API

Welcome to the Book Catalog API! This project provides a RESTful service to manage a catalog of books. The API is built using Spring Boot and includes features like data persistence, security, and Swagger documentation.

## Table of Contents

- [Book Catalog API](#book-catalog-api)
  - [Table of Contents](#table-of-contents)
  - [Project Description](#project-description)
  - [Installation](#installation)
    - [Prerequisites](#prerequisites)
    - [Dependencies](#dependencies)
    - [Setup](#setup)
  - [Running the Project](#running-the-project)
  - [API Endpoints](#api-endpoints)
  - [Database Initialization](#database-initialization)
  - [Swagger Documentation](#swagger-documentation)

## Project Description

The Book Catalog API allows users to create, retrieve, update, and delete books in a catalog. The API supports various operations such as searching for books by author, title, genre, and publication status.

## Installation

### Prerequisites

- Java 22 or later
- Maven

### Dependencies

The project uses the following dependencies:
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Web
- H2 Database
- Spring Boot Starter Test
- Spring Security Test
- Springdoc OpenAPI Starter WebMVC UI
- Spring Boot DevTools
- Jackson Databind

The dependencies are managed using Maven. You can find them in the `pom.xml` file.

### Setup

If you don't have JDK and Maven installed:
- Download the JDK from the official website:
  - [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk22-downloads.html)
  - [OpenJDK](https://jdk.java.net/22/)
- Download Apache Maven from the official website:
  - [Apache Maven](https://maven.apache.org/download.cgi)

After the installation for your operating system use the below steps to proceed:
1. Clone the repository: 
    ```sh
    git clone https://github.com/vvasileios/book-catalog.git
    cd bookcatalog
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

## Running the Project

To run the project, use the following command:
```sh
mvn spring-boot:run
```

The application run at `http://localhost:8080`. When loaded it provides extra information about the project.

## API Endpoints

1. Home Controller
  - GET `/`
    - Welcome message and available endpoints
2. Book Controller
  - GET `/books`
    - Retrieve all books available.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Books retrieved successfully.",
        "data": [
          {
            "id": 1,
            "title": "To Kill a Mockingbird",
            "author": "Harper Lee"
          },
          {
            "id": 2,
            "title": "Go Set a Watchman",
            "author": "Harper Lee"
          },
          {
            "id": 3,
            "title": "Pride and Prejudice",
            "author": "Jane Austen"
          },
          {
            "id": 4,
            "title": "Sense and Sensibility",
            "author": "Jane Austen"
          },
          {
            "id": 5,
            "title": "The Catcher in the Rye",
            "author": "J.D. Salinger"
          },
        ]
      }
      ```
  - GET `/books/{id}`
    - Retrieve a book by its ID.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books/1
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Book retrieved successfully.",
        "data": {
          "id": 1,
          "title": "To Kill a Mockingbird",
          "author": "Harper Lee",
          "summary": "A novel about the serious issues of rape and racial inequality.",
          "published": true,
          "publicationYear": 1960,
          "genre": "Fiction"
        }
      }
      ```
  - POST `/books/add`
    - Add a new book.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books/add
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Book saved successfully",
        "data": {
          "id": 47,
          "title": "To Kill a Mockingbird",
          "author": "Harper Lee",
          "summary": "A novel about the serious issues of rape and racial inequality.",
          "published": false,
          "publicationYear": 1960,
          "genre": "Fiction"
        }
      }
      ```
  - POST `/books`
    - Add multiple new books.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Books saved successfully: 5",
        "data": [
          {
            "id": 48,
            "title": "To Kill a Mockingbird",
            "author": "Harper Lee",
            "summary": "A novel about the serious issues of rape and racial inequality.",
            "published": true,
            "publicationYear": 1960,
            "genre": "Fiction"
          },
          {
            "id": 49,
            "title": "Go Set a Watchman",
            "author": "Harper Lee",
            "summary": "A novel about Scout Finch returning to Maycomb.",
            "published": false,
            "publicationYear": 2015,
            "genre": "Fiction"
          },
          {
            "id": 50,
            "title": "Pride and Prejudice",
            "author": "Jane Austen",
            "summary": "A romantic novel that charts the emotional development of the protagonist Elizabeth Bennet.",
            "published": true,
            "publicationYear": 1813,
            "genre": "Romance"
          },
          {
            "id": 51,
            "title": "Sense and Sensibility",
            "author": "Jane Austen",
            "summary": "A novel about the lives and loves of the Dashwood sisters.",
            "published": false,
            "publicationYear": 1811,
            "genre": "Romance"
          },
          {
            "id": 52,
            "title": "The Catcher in the Rye",
            "author": "J.D. Salinger",
            "summary": "A story about teenage rebellion and alienation.",
            "published": true,
            "publicationYear": 1951,
            "genre": "Fiction"
          },
        ]
      }
      ```
  - PUT `/books/{id}`
    - Update an existing book by ID.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books/49
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Book updated successfully",
        "data": {
          "id": 49,
          "title": "Animal Farm",
          "author": "George Orwell",
          "summary": "An allegorical novella about a group of farm animals who rebel against their human farmer.",
          "published": false,
          "publicationYear": 1945,
          "genre": "Political Satire"
        }
      }
      ```
  - DELETE `/books/{id}`
    - Delete a book by ID.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books/49
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Book deleted successfully",
        "data": null
      }
      ```
  - DELETE `/books`
    - Delete all books.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "All books deleted successfully",
        "data": null
      }
      ```
  - GET `/books/published`
    - Find books by published status.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books/published?status=true or false 
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Books by published status: true, retrieved successfully.",
        "data": [
          {
              "id": 94,
              "title": "To Kill a Mockingbird",
              "author": "Harper Lee",
              "summary": "A novel about the serious issues of rape and racial inequality.",
              "published": true,
              "publicationYear": 1960,
              "genre": "Fiction"
          },
          {
              "id": 96,
              "title": "Pride and Prejudice",
              "author": "Jane Austen",
              "summary": "A romantic novel that charts the emotional development of the protagonist Elizabeth Bennet.",
              "published": true,
              "publicationYear": 1813,
              "genre": "Romance"
          },
          {
              "id": 98,
              "title": "The Catcher in the Rye",
              "author": "J.D. Salinger",
              "summary": "A story about teenage rebellion and alienation.",
              "published": true,
              "publicationYear": 1951,
              "genre": "Fiction"
          }
        ]
      }
      ```
  - GET `/books/author`
    - Find books by author.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books/author?author=harper+lee
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Books by author retrieved successfully.",
        "data": [
          {
            "id": 94,
            "title": "To Kill a Mockingbird",
            "author": "Harper Lee",
            "summary": "A novel about the serious issues of rape and racial inequality.",
            "published": true,
            "publicationYear": 1960,
            "genre": "Fiction"
          },
          {
            "id": 95,
            "title": "Go Set a Watchman",
            "author": "Harper Lee",
            "summary": "A novel about Scout Finch returning to Maycomb.",
            "published": false,
            "publicationYear": 2015,
            "genre": "Fiction"
          }
        ]
      }
      ```
  - GET `/books/title`
    - Find books by title.
      **Example Request:**
        ```bash
        GET http://localhost:8080/books/title?title=To+Kill+a+Mockingbird
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Books by title retrieved successfully.",
        "data": [
          {
            "id": 94,
            "title": "To Kill a Mockingbird",
            "author": "Harper Lee",
            "summary": "A novel about the serious issues of rape and racial inequality.",
            "published": true,
            "publicationYear": 1960,
            "genre": "Fiction"
          }
        ]
      }
      ```
  - GET `/books/genre`
    - Find books by genre.
      **Example Request:**
        ```bash
        GET hhttp://localhost:8080/books/genre?genre=fiction
        ```
      **Example Response:**
      ```json
      {
        "flag": true,
        "code": 200,
        "message": "Books by genre retrieved successfully.",
        "data": [
          {
            "id": 94,
            "title": "To Kill a Mockingbird",
            "author": "Harper Lee",
            "summary": "A novel about the serious issues of rape and racial inequality.",
            "published": true,
            "publicationYear": 1960,
            "genre": "Fiction"
          },
          {
            "id": 95,
            "title": "Go Set a Watchman",
            "author": "Harper Lee",
            "summary": "A novel about Scout Finch returning to Maycomb.",
            "published": false,
            "publicationYear": 2015,
            "genre": "Fiction"
          },
          {
            "id": 98,
            "title": "The Catcher in the Rye",
            "author": "J.D. Salinger",
            "summary": "A story about teenage rebellion and alienation.",
            "published": true,
            "publicationYear": 1951,
            "genre": "Fiction"
          },
          {
            "id": 99,
            "title": "Franny and Zooey",
            "author": "J.D. Salinger",
            "summary": "A novel about the Glass family.",
            "published": false,
            "publicationYear": 1961,
            "genre": "Fiction"
          }
        ]
      }
      ```

## Database Initialization

The project uses H2 in-memory database for data persistence. Initial data is provided at start-up for testing purposes through DataLoader class in config folder.
This setup ensures that the database is populated with books every time the project reloads or is initialized. Data can be found in resources folder.

## Swagger Documentation

Swagger UI is available to interact with the API and  view documentation. Access point: `http://localhost:8080/swagger-ui/index.html#/`.