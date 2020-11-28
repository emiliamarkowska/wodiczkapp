package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.model.HourlyUsage;
import com.widoczka.wodiczkapp.services.HourlyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HourlyUsageController {
    private final HourlyUsageService hourlyUsageService;

    @Autowired
    public HourlyUsageController(HourlyUsageService hourlyUsageService) {
        this.hourlyUsageService = hourlyUsageService;
    }
}
