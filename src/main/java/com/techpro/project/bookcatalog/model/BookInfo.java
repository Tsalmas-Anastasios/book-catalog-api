package com.techpro.project.bookcatalog.model;

/**
 * This class represents a BookInfo entity.
 * It contains the fields of a book, such as title, author, and ID.
 * This class is used to provide a simplified view of a book entity when needed.
 */
public class BookInfo {
  private Long id;
  private String title;
  private String author;

  public BookInfo(Long id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
