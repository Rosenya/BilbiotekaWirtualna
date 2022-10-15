package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBookByCategoryIdOrNameOrAuthorOrEanOrTypeOrAvailibility(
            Long categoryId,
            String name,
            String author,
            String ean,
            String type,
            String availibility){
        return bookRepository.findBookByCategoryIdOrNameOrAuthorOrEanOrTypeOrAvailibility(
                categoryId,
                name,
                author,
                ean,
                type,
                availibility);
    }

    public void addBook(Book book){
        bookRepository.save(book);
        log.info("Dodano książkę: " + book.getName());
    }

    public void editBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
        log.info("Usunięto książkę o id: " + id);
    }

}
