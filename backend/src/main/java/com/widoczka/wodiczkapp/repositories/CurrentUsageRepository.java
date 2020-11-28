package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.CurrentUsage;
import com.widoczka.wodiczkapp.model.HourlyUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrentUsageRepository extends CrudRepository<CurrentUsage, Integer> {

    @Query(value = "select round(sum(current_usages_categories.rate), 2) from current_usages_categories\n" +
            "join categories on categories.id = current_usages_categories.category_id\n" +
            "join current_usages on current_usages.id = current_usages_categories.current_usage_id\n" +
            "where categories.id = :categoryId", nativeQuery = true)
    float getCurrentUsageInLiters(@Param("categoryId") Integer categoryId);



}
