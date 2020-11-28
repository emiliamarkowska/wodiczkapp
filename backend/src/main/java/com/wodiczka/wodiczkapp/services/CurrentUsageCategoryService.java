package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.CurrentUsageCategory;
import com.wodiczka.wodiczkapp.repositories.CurrentUsageCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentUsageCategoryService {
    private final CurrentUsageCategoryRepository currentUsageCategoryRepository;

    @Autowired
    public CurrentUsageCategoryService(CurrentUsageCategoryRepository currentUsageActivityLabelRepository) {
        this.currentUsageCategoryRepository = currentUsageActivityLabelRepository;
    }

    public void addCurrentUsageActivity(CurrentUsageCategory currentUsageCategory) {
        currentUsageCategoryRepository.save(currentUsageCategory);
    }

}
