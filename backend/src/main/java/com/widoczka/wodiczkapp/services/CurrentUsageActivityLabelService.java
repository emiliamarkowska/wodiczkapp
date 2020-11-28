package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.CurrentUsageActivityLabel;
import com.widoczka.wodiczkapp.repositories.CurrentUsageActivityLabelRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrentUsageActivityLabelService {
    private final CurrentUsageActivityLabelRepository currentUsageActivityLabelRepository;

    public CurrentUsageActivityLabelService(CurrentUsageActivityLabelRepository currentUsageActivityLabelRepository) {
        this.currentUsageActivityLabelRepository = currentUsageActivityLabelRepository;
    }

    public void addCurrentUsageActivity(CurrentUsageActivityLabel currentUsageActivityLabel) {
        currentUsageActivityLabelRepository.save(currentUsageActivityLabel);
    }
}
