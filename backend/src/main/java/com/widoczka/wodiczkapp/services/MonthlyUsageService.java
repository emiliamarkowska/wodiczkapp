package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.MonthlyUsage;
import com.widoczka.wodiczkapp.repositories.MonthlyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthlyUsageService {
    private MonthlyUsageRepository monthlyUsageRepository;

    @Autowired
    public MonthlyUsageService(MonthlyUsageRepository monthlyUsageRepository) {
        this.monthlyUsageRepository = monthlyUsageRepository;
    }

    public void addMonthlyUsage(MonthlyUsage monthlyUsage){
        monthlyUsageRepository.save(monthlyUsage);
    }
}
