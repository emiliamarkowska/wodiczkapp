package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.DailyUsage;
import com.wodiczka.wodiczkapp.repositories.CurrentUsageCategoryRepository;
import com.wodiczka.wodiczkapp.repositories.DailyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyUsageService {
    private DailyUsageRepository dailyUsageRepository;
    private ActiveCategoryService activeCategoryService;
    private CurrentUsageCategoryRepository dailyUsageCategoryRepository;

    @Autowired
    public DailyUsageService(DailyUsageRepository dailyUsageRepository,
                             ActiveCategoryService activeCategoryService,
                             CurrentUsageCategoryRepository currentUsageCategoryRepository) {
        this.dailyUsageRepository = dailyUsageRepository;
        this.activeCategoryService = activeCategoryService;
        this.dailyUsageCategoryRepository = currentUsageCategoryRepository;
    }


    public void addDailyUsage(DailyUsage dailyUsage) {
        dailyUsageRepository.save(dailyUsage);
    }


}
