package com.example.restapitrainingfacility.repository;

import java.util.List;
import java.util.UUID;

import com.example.restapitrainingfacility.entity.Author;
import com.example.restapitrainingfacility.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findBooksByAuthorsId(UUID authorId);

    List<Book> findByYear(Short year);

    List<Book> findByGenre(String genre);

    List<Book> findByPublisher(String publisher);

    List<Book> findByTitleContaining(String title);

    List<Book> findByAuthorsContains(Author author);
}
