package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.model.Category;
import com.widoczka.wodiczkapp.model.CurrentUsage;
import com.widoczka.wodiczkapp.services.CurrentUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addCurrentUsage(List<Category> categories){
        CurrentUsage currentUsage = new CurrentUsage(LocalDateTime.now());
        currentUsageService.addCurrentUsage(currentUsage);
    }
}
