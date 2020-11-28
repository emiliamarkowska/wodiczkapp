package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.Category;
import com.wodiczka.wodiczkapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addActivityLabel(Category categoryLabel){
        categoryRepository.save(categoryLabel);
    }
}