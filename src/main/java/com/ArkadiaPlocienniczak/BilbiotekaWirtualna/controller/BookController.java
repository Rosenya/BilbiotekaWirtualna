package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@CrossOrigin
public class BookController {

    /*
@param http methods. i've also tested them via postman to check responsiveness.
@return @getMapping and @postMapping are responsive also via frontend
 */


    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public @ResponseBody ResponseEntity<List<Book>> getBook(@PathVariable(required = false, name="categoryId") Long categoryId,
                              @PathVariable(required = false, name="name") String name,
                              @PathVariable(required = false, name="author") String author,
                              @PathVariable(required = false, name="ean") String ean,
                              @PathVariable(required = false, name="type") String type,
                              @PathVariable(required = false, name="availibility") String availibility) {
        if(categoryId == null && name == null && author == null && ean == null && type == null && availibility == null){
            return new ResponseEntity<>(bookService.getBook(),HttpStatus.OK);
        }
        List<Book> book = bookService.getBookByCategoryIdOrNameOrAuthorOrEanOrTypeOrAvailibility(categoryId, name, author, ean, type, availibility);
        return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
    }

    @PostMapping("/books/addBook")
    public ResponseEntity addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/books/editBook")
    public ResponseEntity editBook(@RequestBody Book book){
        bookService.editBook(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/books/deleteBook")
    public ResponseEntity deleteBook(@RequestParam("id") Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok(null);
    }

}
