package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.services.ActiveCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveCategoryController {
    private final ActiveCategoryService activeCategoryService;

    @Autowired
    public ActiveCategoryController(ActiveCategoryService activeCategoryService) {
        this.activeCategoryService = activeCategoryService;
    }
}