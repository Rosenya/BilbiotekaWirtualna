package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.service;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Book;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Category;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.User;
import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
        log.info("Dodano kategorię: " + category.getName());
    }

    public void editCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
        log.info("Usunięto kategorię o id: " + id);
    }
}
