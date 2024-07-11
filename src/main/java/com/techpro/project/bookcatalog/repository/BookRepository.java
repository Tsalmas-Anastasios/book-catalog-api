package com.techpro.project.bookcatalog.repository;

import com.techpro.project.bookcatalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * This interface extends JpaRepository to provide CRUD operations for the Book
 * entity.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByPublished(boolean published);

  List<Book> findByTitleContainingIgnoreCase(String title);

  List<Book> findByAuthorContainingIgnoreCase(String author);

  List<Book> findByGenreContainingIgnoreCase(String genre);

  Optional<Book> findByTitleAndAuthorContainingIgnoreCase(String title, String author);
}
