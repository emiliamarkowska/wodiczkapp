package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.response_model.CategoriesResponse;
import com.wodiczka.wodiczkapp.services.DailyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyUsageController {
    private final DailyUsageService dailyUsageService;

    @Autowired
    public DailyUsageController(DailyUsageService dailyUsageService) {
        this.dailyUsageService = dailyUsageService;
    }


//    @CrossOrigin
//    @GetMapping(value = "/api/usage/current-day",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public CategoriesResponse getCurrentUsageCategoriesToLiters() {
//        return dailyUsageService.getCategoriesToLiters();
//    }

}
