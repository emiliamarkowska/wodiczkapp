package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.model.AnnualUsage;
import com.widoczka.wodiczkapp.services.AnnualUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class AnnualUsageController {
    private final AnnualUsageService annualUsageService;

    @Autowired
    public AnnualUsageController(AnnualUsageService annualUsageService) {
        this.annualUsageService = annualUsageService;
    }
}
