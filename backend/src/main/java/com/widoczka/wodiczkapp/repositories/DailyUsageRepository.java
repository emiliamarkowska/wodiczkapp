package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.DailyUsage;
import org.springframework.data.repository.CrudRepository;

public interface DailyUsageRepository extends CrudRepository<DailyUsage, Integer> {
}
