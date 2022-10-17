package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginRegisterController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/rejestracja")
    public String getRegister() {
        return "loginPages/register";
    }

}