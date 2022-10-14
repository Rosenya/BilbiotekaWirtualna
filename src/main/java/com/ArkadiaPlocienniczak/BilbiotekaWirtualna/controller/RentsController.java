package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.BookService;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.RentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RentsController {

    private final RentsService rentsService;
    private final BookService bookService;

    public RentsController (RentsService rentsService,BookService bookService) {
        this.rentsService = rentsService;
        this.bookService = bookService;
    }

    @GetMapping("/rents")
    public String getRents(){
        return "rents";
    }

    @PatchMapping("/editRents")
    public String editRents(@PathVariable("id") Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "editRents";
    }
}
