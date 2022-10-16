package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity getUser(@PathVariable(required = false, name="userID") Long id){
        if(id == null){
            return new ResponseEntity<>(userService.getUser(),HttpStatus.OK);
        }
        User user=userService.getUser(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("/users/addUser")
    public ResponseEntity addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/editUser")
    public ResponseEntity editUser(@RequestBody User user){
        userService.editUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/deleteUser")
    public ResponseEntity deleteUser(@RequestParam("id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok(null);
    }

}
