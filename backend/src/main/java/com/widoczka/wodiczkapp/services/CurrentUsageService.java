package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.CurrentUsage;
import com.widoczka.wodiczkapp.repositories.CurrentUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentUsageService {
    private CurrentUsageRepository currentUsageRepository;

    @Autowired
    public CurrentUsageService(CurrentUsageRepository currentUsageRepository) {
        this.currentUsageRepository = currentUsageRepository;
    }

    public void addCurrentUsage(CurrentUsage currentUsage){
        currentUsageRepository.save(currentUsage);
    }

    public void deleteCurrentUsage(int id) {
        currentUsageRepository.deleteById(id);
    }
}
