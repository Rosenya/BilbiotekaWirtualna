package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Category;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class CategoryController {

    /*
@param http methods. i've also tested them via postman to check responsiveness.
 */

    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity getCategory(@PathVariable(required = false, name="categoryID") Long id){
        if(id == null){
            return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
        }
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @PostMapping("/category/addCategory")
    public ResponseEntity addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok(category);
    }


    @PutMapping("/category/editCategory")
    public ResponseEntity editCategory(@RequestBody Category category){
        categoryService.editCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/category/deleteCategory")
    public ResponseEntity deleteCategory(@RequestParam("id") Long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(null);
    }
}
