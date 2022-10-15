package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Rents;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.BookService;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.RentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class RentsController {

    private final RentsService rentsService;
    private final BookService bookService;

    public RentsController (RentsService rentsService,BookService bookService) {
        this.rentsService = rentsService;
        this.bookService = bookService;
    }

    @GetMapping("/rents")
    public String getRentsList(Model model) {
        List<Rents> rents = rentsService.getRents();
        model.addAttribute("rents", rents);
        return "rentsList";
    }

    @PostMapping("/rents")
    public RedirectView addRent(@ModelAttribute Rents newRent){
        rentsService.addRent(newRent);
        return new RedirectView("rents");
    }

    @DeleteMapping("/rents")
    public ResponseEntity deleteRentById(@RequestParam("id") Long id){
        rentsService.deleteRentById(id);
        return (ResponseEntity) ResponseEntity.noContent();
    }
}
