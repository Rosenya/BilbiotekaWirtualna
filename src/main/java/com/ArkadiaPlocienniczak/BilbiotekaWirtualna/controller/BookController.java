package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.BookService;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/ksiazki")
    public String getBookList(Model model) {
        List<Book> book = bookService.getBook();
        model.addAttribute("book", book);
        return "ksiazki";
    }

    @GetMapping("/fantasy")
    public String getFantasy(){
        return "books";
    }

    @GetMapping("/kryminal")
    public String get(){
        return "books";
    }

    @GetMapping("/scifi")
    public String getSciFi(){
        return "books";
    }


}
