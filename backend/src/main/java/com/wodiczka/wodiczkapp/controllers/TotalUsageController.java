package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.services.TotalUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotalUsageController {
    private final TotalUsageService totalUsageService;

    @Autowired
    public TotalUsageController(TotalUsageService totalUsageService) {
        this.totalUsageService = totalUsageService;
    }
}
