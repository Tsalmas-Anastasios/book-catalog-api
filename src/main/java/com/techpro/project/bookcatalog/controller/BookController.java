package com.techpro.project.bookcatalog.controller;

import com.techpro.project.bookcatalog.model.Book;
import com.techpro.project.bookcatalog.service.BookService;
import com.techpro.project.bookcatalog.system.result.Result;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class is responsible for handling HTTP requests related to the Book
 * entity. It defines the endpoints for creating, reading, updating, and
 * deleting books.
 * It also provides endpoints for searching books by different criteria.
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/books")
public class BookController {
  @Autowired
  BookService bookService;

  // #region Get books/book
  @Tag(name = "Get", description = "Get books")
  @Operation(summary = "Get all books", description = "Get all books")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "No books found. Please consider adding some books!", content = @Content)
  })
  @GetMapping
  public Result getAllBooks() {
    return bookService.getAllBooks();
  }

  @Tag(name = "Get")
  @Operation(summary = "Get book by id", description = "Get book by providing a specific id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "Book not found with id", content = @Content)
  })
  @GetMapping("/{id}")
  public Result getBookById(@PathVariable("id") Long id) {
    return bookService.getBookById(id);
  }
  // #endregion

  // #region Create books
  @Tag(name = "Post", description = "Create books")
  @Operation(summary = "Create book", description = "Create a single new book")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Book created", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "400", description = "Error creating book", content = @Content)
  })
  @PostMapping("/add")
  public Result createBook(@RequestBody Book book) {
    return bookService.createBook(book);
  }

  @Tag(name = "Post")
  @Operation(summary = "Create books", description = "Create multiple new books")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Books created", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "400", description = "Error creating books", content = @Content)
  })
  @PostMapping
  public Result createBooks(@RequestBody List<Book> books) {
    return bookService.createBooks(books);
  }
  // #endregion

  // #region Update book/books
  @Tag(name = "Put", description = "Update book")
  @Operation(summary = "Update book", description = "Update a book by providing a specific id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Book updated", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "Book not found with id", content = @Content)
  })
  @PutMapping("/{id}")
  public Result updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
    return bookService.updateBook(id, book);
  }
  // #endregion

  // #region Delete book/books
  @Tag(name = "Delete", description = "Delete books")
  @Operation(summary = "Delete book", description = "Delete a book by providing a specific id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Book deleted", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "Book not found with id", content = @Content)
  })
  @DeleteMapping("/{id}")
  public Result deleteBook(@PathVariable("id") Long id) {
    return bookService.deleteBook(id);
  }

  @Tag(name = "Delete")
  @Operation(summary = "Delete books", description = "Deletes all books from the database")
  @ApiResponses({
      @ApiResponse(responseCode = "204", description = "All books deleted", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "No books found. Please consider adding some books!", content = @Content)
  })
  @DeleteMapping
  public Result deleteAllBooks() {
    return bookService.deleteAllBooks();
  }
  // #endregion

  // #region Search book/books
  @Tag(name = "Get")
  @Operation(summary = "Get books by status", description = "Get books by published status")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "No books found. Please consider adding some books!", content = @Content)
  })
  @GetMapping("/published")
  public Result findByPublished(@RequestParam boolean status) {
    return bookService.findByPublished(status);
  }

  @Tag(name = "Get")
  @Operation(summary = "Get books by author", description = "Get books by author")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "No books found. Please consider adding some books!", content = @Content)
  })
  @GetMapping("/author")
  public Result findByAuthor(@RequestParam String author) {
    return bookService.findByAuthor(author);
  }

  @Tag(name = "Get")
  @Operation(summary = "Get books title", description = "Get books by title")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "No books found. Please consider adding some books!", content = @Content)
  })
  @GetMapping("/title")
  public Result findByTitle(@RequestParam String title) {
    return bookService.findByTitle(title);
  }

  @Tag(name = "Get")
  @Operation(summary = "Get books by genre", description = "Get books by genre")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = Result.class)) }),
      @ApiResponse(responseCode = "404", description = "No books found. Please consider adding some books!", content = @Content)
  })
  @GetMapping("/genre")
  public Result findByGenre(@RequestParam String genre) {
    return bookService.findByGenre(genre);
  }
  // #endregion
}
