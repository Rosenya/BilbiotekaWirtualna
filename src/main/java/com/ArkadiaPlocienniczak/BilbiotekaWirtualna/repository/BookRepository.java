package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.repository;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategoryId(Long categoryId);
    List<Book> findByName(String name);
    List<Book> findByAuthor(String author);
    List<Book> findByEan(String ean);
    List<Book> findByType(String type);
    List<Book> findBookByCategoryIdOrNameOrAuthorOrEanOrType(Long categoryId, String name, String author, String ean, String type);
}
