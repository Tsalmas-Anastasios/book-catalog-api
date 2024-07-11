package com.techpro.project.bookcatalog.service;

import com.techpro.project.bookcatalog.model.Book;

import com.techpro.project.bookcatalog.system.result.Result;
import java.util.List;

/**
 * This interface defines the methods that the BookService class must implement.
 * It provides the basic CRUD operations for the Book entity.
 */
public interface BookService {
  Result getAllBooks();

  Result getBookById(Long id);

  Result createBook(Book book);

  Result createBooks(List<Book> books);

  Result updateBook(Long id, Book book);

  Result deleteBook(Long id);

  Result deleteAllBooks();

  Result findByPublished(boolean status);

  Result findByAuthor(String author);

  Result findByTitle(String title);

  Result findByGenre(String genre);
}
