package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.DailyUsage;
import org.springframework.data.repository.CrudRepository;

public interface DailyUsageRepository extends CrudRepository<DailyUsage, Integer> {
}
