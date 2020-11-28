package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.ActivityLabel;
import com.widoczka.wodiczkapp.repositories.ActivityLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLabelService {
    private ActivityLabelRepository activityLabelRepository;

    @Autowired
    public ActivityLabelService(ActivityLabelRepository activityLabelRepository) {
        this.activityLabelRepository = activityLabelRepository;
    }

    public void addActivityLabel(ActivityLabel activityLabel){
        activityLabelRepository.save(activityLabel);
    }
}