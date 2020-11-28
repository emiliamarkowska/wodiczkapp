package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.HourlyUsage;
import com.widoczka.wodiczkapp.repositories.HourlyUsageRepository;
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
