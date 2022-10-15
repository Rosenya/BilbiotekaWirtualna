package com.ArkadiaPlocienniczak.BilbiotekaWirtualna.repository;

import com.ArkadiaPlocienniczak.BilbiotekaWirtualna.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}



