package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.HourlyUsage;
import org.springframework.data.repository.CrudRepository;

public interface HourlyUsageRepository extends CrudRepository<HourlyUsage, Integer> {
}
