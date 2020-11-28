package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.services.HourlyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HourlyUsageController {
    private final HourlyUsageService hourlyUsageService;

    @Autowired
    public HourlyUsageController(HourlyUsageService hourlyUsageService) {
        this.hourlyUsageService = hourlyUsageService;
    }
}
