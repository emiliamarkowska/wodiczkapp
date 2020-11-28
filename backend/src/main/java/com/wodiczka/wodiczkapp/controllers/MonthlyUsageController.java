package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.services.MonthlyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthlyUsageController {
    private final MonthlyUsageService monthlyUsageService;

    @Autowired
    public MonthlyUsageController(MonthlyUsageService monthlyUsageService) {
        this.monthlyUsageService = monthlyUsageService;
    }
}
