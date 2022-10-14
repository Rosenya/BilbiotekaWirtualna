package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.BookService;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public @ResponseBody ResponseEntity<List<Book>> getBook(@PathVariable("categoryId") Long categoryId,
                              @PathVariable("name") String name,
                              @PathVariable("author") String author,
                              @PathVariable("ean") String ean,
                              @PathVariable("type") String type) {
        if(categoryId == null && name == null && author == null && ean == null && type == null){
            return new ResponseEntity<>(bookService.getBook(),HttpStatus.OK);
        }
        List<Book> book = bookService.getBookByCategoryIdOrNameOrAuthorOrEanOrType(categoryId, name, author, ean, type);
        return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public RedirectView addBook(@RequestBody Book newBook){
        bookService.addBook(newBook);
        return new RedirectView("books");
    }

    @PutMapping("/books")
    public ResponseEntity editBook(@RequestBody Book book){
        bookService.editBook(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/books")
    public ResponseEntity deleteBook(@RequestParam("id") Long id){
        bookService.deleteBookById(id);
        return (ResponseEntity) ResponseEntity.noContent();
    }

    @PatchMapping("/editMyAccount")
    public String editMyAccount(@PathVariable("id") Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "myAccount/editMyAccount";
    }

}
