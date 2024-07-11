package com.techpro.project.bookcatalog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents a Book entity.
 * It contains the fields of a book, such as title, author, summary, publication
 * year, genre, and published status.
 */
@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "author")
  private String author;
  @Column(name = "summary")
  private String summary;
  @Column(name = "published")
  private boolean published;
  @Column(name = "publicationYear")
  private int publicationYear;
  @Column(name = "genre")
  private String genre;

  public Book() {
  }

  public Book(String title, String author, String summary, boolean published, int publicationYear, String genre) {
    this.title = title;
    this.author = author;
    this.summary = summary;
    this.publicationYear = publicationYear;
    this.genre = genre;
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

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int year) {
    this.publicationYear = year;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", summary='" + summary + '\'' +
        ", published=" + published +
        ", year=" + publicationYear +
        ", genre='" + genre + '\'' +
        '}';
  }
}
