package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.CurrentUsageCategory;
import com.widoczka.wodiczkapp.model.HourlyUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrentUsageCategoryRepository extends CrudRepository<CurrentUsageCategory, Integer> {


}
