package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.services.DailyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyUsageController {
    private final DailyUsageService dailyUsageService;

    @Autowired
    public DailyUsageController(DailyUsageService dailyUsageService) {
        this.dailyUsageService = dailyUsageService;
    }
}
