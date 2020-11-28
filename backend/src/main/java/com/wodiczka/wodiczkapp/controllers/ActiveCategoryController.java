package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.services.ActiveCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveCategoryController {
    private final ActiveCategoryService activeCategoryService;

    @Autowired
    public ActiveCategoryController(ActiveCategoryService activeCategoryService) {
        this.activeCategoryService = activeCategoryService;
    }

    @PutMapping(value = "/api/active-category/{categoryId}")
    public void addActiveCategory(@PathVariable Integer categoryId) {
        activeCategoryService.addActiveCategoryByCategory(categoryId);
    }
}