package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.repositories.DailyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyUsageService {
    private DailyUsageRepository dailyUsageRepository;

    @Autowired
    public DailyUsageService(DailyUsageRepository dailyUsageRepository) {
        this.dailyUsageRepository = dailyUsageRepository;
    }
}
