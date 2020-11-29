package com.wodiczka.wodiczkapp.controllers;

import com.wodiczka.wodiczkapp.model.Usage;
import com.wodiczka.wodiczkapp.response_model.CurrentDayResponse;
import com.wodiczka.wodiczkapp.response_model.DaysResponse;
import com.wodiczka.wodiczkapp.services.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class UsageController {
    private final UsageService usageService;

    @Autowired
    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }

    @PostMapping(value = "/add-current-usage",
            consumes = "text/plain",
            produces = "application/text")
    public void addCurrentUsage(){
        Usage usage = new Usage(LocalDateTime.now());
        usageService.addUsage(usage);
    }

    @CrossOrigin
    @GetMapping(value = "/api/usage/current-day",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CurrentDayResponse getCurrentDayUsage() {
        return usageService.getCurrentDayUsage();
    }


    @CrossOrigin
    @GetMapping(value = "/api/usage/days/days_amount/{amount}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DaysResponse getCurrentDayUsage(@PathVariable int amount) {
        return usageService.getDaysUsage(amount);
    }
}
