package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.model.MonthlyUsage;
import com.widoczka.wodiczkapp.services.MonthlyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MonthlyUsageController {
    private final MonthlyUsageService monthlyUsageService;

    @Autowired
    public MonthlyUsageController(MonthlyUsageService monthlyUsageService) {
        this.monthlyUsageService = monthlyUsageService;
    }

    @PostMapping(value = "/add-monthlyUsage",
            consumes = "text/plain",
            produces = "application/text")
    public void addRecord(){
        MonthlyUsage monthlyUsage = new MonthlyUsage(LocalDate.now());
        monthlyUsageService.addMonthlyUsage(monthlyUsage);
    }
}
