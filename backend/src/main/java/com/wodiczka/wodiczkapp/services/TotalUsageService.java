package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.TotalUsage;
import com.wodiczka.wodiczkapp.repositories.TotalUsageRepository;
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
