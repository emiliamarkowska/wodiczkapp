package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.HourlyUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface HourlyUsageRepository extends CrudRepository<HourlyUsage, Integer> {
    @Query(value = "select round(sum(hourly_usages.sum), 2) from hourly_usages\n" +
            "where hourly_usages.category_id = :categoryId and hour(hourly_usages.date_time) = (hour(dateTime));", nativeQuery = true)
    float getCurrentUsageInLiters(@Param("categoryId") Integer categoryId,
                                  @Param("dateTime") LocalDateTime dateTime);
}
