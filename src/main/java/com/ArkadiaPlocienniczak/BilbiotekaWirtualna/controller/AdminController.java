package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/adminPanel")
    public String getAdmin() {

        return "adminPanel";
    }
}

