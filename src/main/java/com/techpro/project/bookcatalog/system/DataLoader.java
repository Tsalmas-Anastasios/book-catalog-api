package com.techpro.project.bookcatalog.system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techpro.project.bookcatalog.model.Book;
import com.techpro.project.bookcatalog.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * This class is responsible for loading initial data into the book catalog
 * database.
 * It implements the CommandLineRunner interface to run the data loading process
 * when the application starts.
 * It reads a JSON file containing book data, converts it into a list of Book
 * objects using Jackson ObjectMapper,
 * and saves the books to the database using the BookRepository.
 */
@Component
public class DataLoader implements CommandLineRunner {

  private final BookRepository bookRepository;

  public DataLoader(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {
    };
    InputStream inputStream = new ClassPathResource("books.json").getInputStream();
    try {
      List<Book> books = mapper.readValue(inputStream, typeReference);
      bookRepository.saveAll(books);
      System.out.println("Books saved to the database.");
    } catch (Exception e) {
      System.out.println("Unable to save books: " + e.getMessage());
    }
  }
}
