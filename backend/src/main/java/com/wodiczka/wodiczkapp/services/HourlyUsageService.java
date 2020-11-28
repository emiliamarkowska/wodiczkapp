package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.HourlyUsage;
import com.wodiczka.wodiczkapp.repositories.HourlyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HourlyUsageService {
    private HourlyUsageRepository hourlyUsageRepository;

    @Autowired
    public HourlyUsageService(HourlyUsageRepository hourlyUsageRepository) {
        this.hourlyUsageRepository = hourlyUsageRepository;
    }

    public void addHourlyUsage(HourlyUsage hourlyUsage){
        hourlyUsageRepository.save(hourlyUsage);
    }
}
