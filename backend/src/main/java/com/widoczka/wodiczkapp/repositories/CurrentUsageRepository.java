package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.CurrentUsage;
import org.springframework.data.repository.CrudRepository;

public interface CurrentUsageRepository extends CrudRepository<CurrentUsage, Integer> {
}
