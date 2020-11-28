package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.model.ActivityLabel;
import com.widoczka.wodiczkapp.services.ActivityLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityLabelController {
    private final ActivityLabelService activityLabelService;

    @Autowired
    public ActivityLabelController(ActivityLabelService activityLabelService) {
        this.activityLabelService = activityLabelService;
    }
}