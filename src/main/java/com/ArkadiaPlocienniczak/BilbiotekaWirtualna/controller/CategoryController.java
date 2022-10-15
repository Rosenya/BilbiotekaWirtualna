package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.controller;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Category;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String getCategoryList(Model model) {
        List<Category> category = categoryService.getCategories();
        model.addAttribute("category", category);
        return "category";
    }

    @PostMapping("/category")
    public RedirectView addCategoty(@ModelAttribute Category newCategory){
        categoryService.addCategory(newCategory);
        return new RedirectView("category");
    }

    @PutMapping("/category")
    public ResponseEntity editCategory(@RequestBody Category category){
        categoryService.editCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/category")
    public ResponseEntity deleteCategory(@RequestParam("id") Long id){
        categoryService.deleteCategoryById(id);
        return (ResponseEntity) ResponseEntity.noContent();
    }
}
