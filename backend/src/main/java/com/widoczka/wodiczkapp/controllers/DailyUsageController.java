package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.model.DailyUsage;
import com.widoczka.wodiczkapp.services.DailyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DailyUsageController {
    private final DailyUsageService dailyUsageService;

    @Autowired
    public DailyUsageController(DailyUsageService dailyUsageService) {
        this.dailyUsageService = dailyUsageService;
    }
}
