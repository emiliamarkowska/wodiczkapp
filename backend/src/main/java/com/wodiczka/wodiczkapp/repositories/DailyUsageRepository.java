package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.DailyUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface DailyUsageRepository extends CrudRepository<DailyUsage, Integer> {
    @Query(value = "select round(sum(daily_usages.sum), 2) from daily_usages\n" +
            "where daily_usages.category_id = :categoryId and \n" +
            "year(daily_usages.date) = (hour(:dateTime)) and\n" +
            "month(daily_usages.date) = (hour(:dateTime)) and\n" +
            "day(daily_usages.date) = (hour(:dateTime))", nativeQuery = true)
    float getDailyUsageInLiters(@Param("categoryId") Integer categoryId,
                                 @Param("dateTime") LocalDateTime dateTime);


    @Query(value = "select round(sum(daily_usages.sum), 2) from daily_usages\n" +
            "where year(daily_usages.date) = (hour(:dateTime)) and\n" +
            "month(daily_usages.date) = (hour(:dateTime)) and\n" +
            "day(daily_usages.date) = (hour(:dateTime))", nativeQuery = true)
    float getTotalDailyUsageInLiters(@Param("dateTime") LocalDateTime dateTime);


    @Query(value = "select round(sum(hourly_usages.sum), 2) from hourly_usages\n" +
            "where year(hourly_usages.date_time) = (hour(:dateTime)) and\n" +
            "month(hourly_usages.date_time) = (hour(:dateTime)) and\n" +
            "day(hourly_usages.date_time) = (hour(:dateTime))", nativeQuery = true)
    float getTotalCurrentDailyUsageInLiters(@Param("dateTime") LocalDateTime dateTime);
}
