package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.ActiveCategory;
import com.wodiczka.wodiczkapp.model.Category;
import com.wodiczka.wodiczkapp.repositories.ActiveCategoryRepository;
import com.wodiczka.wodiczkapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActiveCategoryService {
    private ActiveCategoryRepository activeCategoryRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ActiveCategoryService(ActiveCategoryRepository activeCategoryRepository, CategoryRepository categoryRepository) {
        this.activeCategoryRepository = activeCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public void addActiveCategory(ActiveCategory activeCategory){
        activeCategoryRepository.save(activeCategory);
    }

    public List<ActiveCategory> getActiveCategories(){
        return (List<ActiveCategory>) activeCategoryRepository.findAll();
    }

    public void addActiveCategoryByCategory(Integer categoryId) {
        List<ActiveCategory> activeCategories = getActiveCategories();
        Optional<ActiveCategory> activeCategory = activeCategories
                .stream()
                .filter(c -> c.getCategory().getId() == categoryId)
                .findFirst();
        if (activeCategory.isPresent()) {
            activeCategory.get().setDateTime(LocalDateTime.now());
            activeCategoryRepository.save(activeCategory.get());
        } else {
            Optional<Category> category = categoryRepository.findById(categoryId);
            if (category.isPresent()) {
                ActiveCategory newActiveCategory = new ActiveCategory(category.get(), LocalDateTime.now());
                activeCategoryRepository.save(newActiveCategory);
            }
        }
    }

}
