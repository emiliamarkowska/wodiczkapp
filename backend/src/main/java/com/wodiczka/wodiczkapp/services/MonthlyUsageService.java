package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.MonthlyUsage;
import com.wodiczka.wodiczkapp.repositories.MonthlyUsageRepository;
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
