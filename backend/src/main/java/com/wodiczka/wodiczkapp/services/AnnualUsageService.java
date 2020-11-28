package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.AnnualUsage;
import com.wodiczka.wodiczkapp.repositories.AnnualUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnualUsageService {
    private AnnualUsageRepository annualUsageRepository;

    @Autowired
    public AnnualUsageService(AnnualUsageRepository annualUsageRepository) {
        this.annualUsageRepository = annualUsageRepository;
    }

    public void addAnnualUsage(AnnualUsage annualUsage){
        annualUsageRepository.save(annualUsage);
    }
}
