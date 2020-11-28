package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.MonthlyUsage;
import org.springframework.data.repository.CrudRepository;

public interface MonthlyUsageRepository extends CrudRepository<MonthlyUsage, Integer> {
}
