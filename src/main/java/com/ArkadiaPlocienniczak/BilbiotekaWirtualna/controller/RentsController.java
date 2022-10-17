package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Rents;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.BookService;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.RentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class RentsController {

    /*
@param http methods. i've also tested them via postman to check responsiveness.
 */

    private final RentsService rentsService;
    private final BookService bookService;

    public RentsController (RentsService rentsService,BookService bookService) {
        this.rentsService = rentsService;
        this.bookService = bookService;
    }

    @GetMapping("/rents")
    public ResponseEntity getRents(@PathVariable(required = false, name="rentId") Long id){
        if(id == null){
            return new ResponseEntity<>(rentsService.getRents(), HttpStatus.OK);
        }
        Rents rents = rentsService.getRentById(id);
        return new ResponseEntity(rents, HttpStatus.OK);
    }

    @PostMapping("/rents/addRent")
    public ResponseEntity addRent(@RequestBody Rents rent){
        rentsService.addRent(rent);
        return ResponseEntity.ok(rent);
    }

    @DeleteMapping("/rents/deleteRent")
    public ResponseEntity deleteRentById(@RequestParam("id") Long id){
        rentsService.deleteRentById(id);
        return ResponseEntity.ok(null);
    }
}
