package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.model.Category;
import com.wodiczka.wodiczkapp.model.CurrentUsage;
import com.wodiczka.wodiczkapp.response_model.CategoriesResponse;
import com.wodiczka.wodiczkapp.services.CurrentUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CurrentUsageController {
    private final CurrentUsageService currentUsageService;

    @Autowired
    public CurrentUsageController(CurrentUsageService currentUsageService) {
        this.currentUsageService = currentUsageService;
    }

    @PostMapping(value = "/add-currentUsage",
            consumes = "text/plain",
            produces = "application/text")
    public void addCurrentUsage(List<Category> categories) {
        CurrentUsage currentUsage = new CurrentUsage(LocalDateTime.now());
        currentUsageService.addCurrentUsage(currentUsage);
    }

    @CrossOrigin
    @GetMapping(value = "/current-usage/get-usage-for-categories",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CategoriesResponse getCurrentUsageCategoriesToLiters() {
        return currentUsageService.getCategoriesToLiters();
    }

}
