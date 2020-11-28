package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.CurrentUsageCategory;
import com.widoczka.wodiczkapp.model.HourlyUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrentUsageCategoryRepository extends CrudRepository<CurrentUsageCategory, Integer> {

    @Query(value = "select categories.name, round(sum(current_usage_category.rate), 2) from current_usage_category\n" +
                   "join categories on categories.id = current_usage_category.category_id\n" +
                   "join current_usages on current_usages.id = current_usage_category.current_usage_id\n" +
                   "group by name", nativeQuery = true)
    public List<HourlyUsage> getHourlyUsage();
}
