package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.ActiveCategory;
import com.widoczka.wodiczkapp.repositories.ActiveCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveCategoryService {
    private ActiveCategoryRepository activeCategoryRepository;

    @Autowired
    public ActiveCategoryService(ActiveCategoryRepository activeCategoryRepository) {
        this.activeCategoryRepository = activeCategoryRepository;
    }

    public void addActiveCategory(ActiveCategory activeCategory){
        activeCategoryRepository.save(activeCategory);
    }

    public List<ActiveCategory> getActiveCategories(){
        return (List<ActiveCategory>) activeCategoryRepository.findAll();
    }

}
