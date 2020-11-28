package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.TotalUsage;
import com.widoczka.wodiczkapp.repositories.TotalUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalUsageService {
    private TotalUsageRepository totalUsageRepository;

    @Autowired
    public TotalUsageService(TotalUsageRepository totalUsageRepository) {
        this.totalUsageRepository = totalUsageRepository;
    }

    public void addTotalUsage(TotalUsage totalUsage){
        totalUsageRepository.save(totalUsage);
    }
}
