package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.MonthlyUsage;
import org.springframework.data.repository.CrudRepository;

public interface MonthlyUsageRepository extends CrudRepository<MonthlyUsage, Integer> {
}
