package com.example.restapitrainingfacility.entity;

import com.example.restapitrainingfacility.entity.Author;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "pages")
    private String pages;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "file")
    private String file;

    @Column(name = "added")
    private String added;

    @Column(name = "modified")
    private String modified;

    @Column(name = "file_added")
    private String fileadded;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_has_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(){
    }

    public Book(String title, String year, String genre, String pages, String publisher, String file, String added, String modified, String fileadded) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.pages = pages;
        this.publisher = publisher;

        setAdded();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getFile() {
        return file;
    }

    public String getAdded() {
        return added;
    }

    public String getModified() {
        return modified;
    }

    public String getFileadded() {
        return fileadded;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }
    public Set<Author> getAuthors() {
        return authors;
    }
    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }
    public void addFile(String file) {
        this.file = file;
    }
    private void setAdded() {this.added = this.modified = new Date();}

    public void setModified() {
        this.modified = new Date();
    }

    public void setFileAdded() {
        this.fileAdded = new Date();
    }


}
