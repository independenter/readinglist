package com.asiainfo.readinglist.entiy;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * JPA实体类
 */
@Entity  //表明它是一个JPA实体
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", initialValue = 1, allocationSize = 1, sequenceName = "BOOK_SEQ")
    private Long id;
    private String reader;
    @Column(name="isbn")
    private String isbn;
    @Column(name="title")
    private String title;
    private String author;
    @Column(name="description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", reader='" + reader + '\'' + ", isbn='" + isbn + '\'' + ", title='" + title + '\'' + ", author='" + author + '\'' + ", description='" + description + '\'' + '}';
    }
}
