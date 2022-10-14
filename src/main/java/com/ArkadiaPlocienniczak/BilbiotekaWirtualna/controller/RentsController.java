package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentsController {

    @GetMapping("/wypozyczone")
    public String getRents(){
        return "rents";
    }

}
