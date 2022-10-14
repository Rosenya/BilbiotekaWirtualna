package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUserList(Model model) {
        List<User> user = userService.getUser();
        model.addAttribute("user", user);
        return "userList";
    }

    @PostMapping("/users")
    public RedirectView addUser(@ModelAttribute User newUser){
            userService.addUser(newUser);
            return new RedirectView("users");
    }

    @PutMapping("/users")
    public ResponseEntity editUser(@RequestBody User user){
        userService.editUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users")
    public ResponseEntity deleteUser(@RequestParam("id") Long id){
        userService.deleteUserById(id);
        return (ResponseEntity) ResponseEntity.noContent();
    }

    @PatchMapping("/editMyAccount")
    public String editMyAccount(@PathVariable("id") Long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "myAccount/editMyAccount";
    }
}
