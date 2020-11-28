package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.services.AnnualUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnualUsageController {
    private final AnnualUsageService annualUsageService;

    @Autowired
    public AnnualUsageController(AnnualUsageService annualUsageService) {
        this.annualUsageService = annualUsageService;
    }
}
