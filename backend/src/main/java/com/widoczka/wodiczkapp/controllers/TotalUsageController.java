package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.model.TotalUsage;
import com.widoczka.wodiczkapp.services.TotalUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class TotalUsageController {
    private final TotalUsageService totalUsageService;

    @Autowired
    public TotalUsageController(TotalUsageService totalUsageService) {
        this.totalUsageService = totalUsageService;
    }

    @PostMapping(value = "/add-totalUsage",
            consumes = "text/plain",
            produces = "application/text")
    public void addRecord(){
        TotalUsage totalUsage = new TotalUsage(LocalDate.now());
        totalUsageService.addTotalUsage(totalUsage);
    }
}
