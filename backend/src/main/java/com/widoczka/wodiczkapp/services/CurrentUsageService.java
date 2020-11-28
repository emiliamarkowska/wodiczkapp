package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.ActiveCategory;
import com.widoczka.wodiczkapp.model.CurrentUsage;
import com.widoczka.wodiczkapp.model.CurrentUsageCategory;
import com.widoczka.wodiczkapp.repositories.CurrentUsageCategoryRepository;
import com.widoczka.wodiczkapp.repositories.CurrentUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentUsageService {
    private CurrentUsageRepository currentUsageRepository;
    private ActiveCategoryService activeCategoryService;
    private CurrentUsageCategoryRepository currentUsageCategoryRepository;

    @Autowired
    public CurrentUsageService(CurrentUsageRepository currentUsageRepository,
                               ActiveCategoryService activeCategoryService,
                               CurrentUsageCategoryRepository currentUsageCategoryRepository) {
        this.currentUsageRepository = currentUsageRepository;
        this.activeCategoryService = activeCategoryService;
        this.currentUsageCategoryRepository = currentUsageCategoryRepository;
    }

    public void addCurrentUsage(CurrentUsage currentUsage) {
        List<ActiveCategory> activeCategoryList = activeCategoryService.getActiveCategories();
        float weightSum = getWeightSum(activeCategoryList);
        List<CurrentUsageCategory> currentUsageCategories = getCurrentUsageCategories(activeCategoryList, currentUsage, weightSum);
        currentUsageRepository.save(currentUsage);
        currentUsageCategoryRepository.saveAll(currentUsageCategories);
    }

    private float getWeightSum(List<ActiveCategory> activeCategories) {
        float weightSum = 0;
        for (ActiveCategory activeCategory : activeCategories) {
            weightSum += activeCategory.getCategory().getRate();
        }
        return weightSum;
    }

    private List<CurrentUsageCategory> getCurrentUsageCategories(List<ActiveCategory> activeCategories, CurrentUsage currentUsage, float weightSum) {
        List<CurrentUsageCategory> currentUsageCategories = new ArrayList<>();
        for (ActiveCategory activeCategory : activeCategories) {
            float rateForCurrentUsage = activeCategory.getCategory().getRate() / weightSum;
            currentUsageCategories.add(new CurrentUsageCategory(activeCategory.getCategory(), currentUsage, rateForCurrentUsage));
        }
        return currentUsageCategories;
    }



    public void deleteCurrentUsage(int id) {
        currentUsageRepository.deleteById(id);
    }
}
