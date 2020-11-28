package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.HourlyUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface HourlyUsageRepository extends CrudRepository<HourlyUsage, Integer> {
    @Query(value = "select round(sum(hourly_usages.sum), 2) from hourly_usages\n" +
            "where hourly_usages.category_id = :categoryId and \n" +
            "year(hourly_usages.date_time) = (hour(:dateTime)) and\n" +
            "month(hourly_usages.date_time) = (hour(:dateTime)) and\n" +
            "day(hourly_usages.date_time) = (hour(:dateTime)) and\n" +
            "hour(hourly_usages.date_time) = (hour(:dateTime))", nativeQuery = true)
    float getHourlyUsageInLiters(@Param("categoryId") Integer categoryId,
                                  @Param("dateTime") LocalDateTime dateTime);



//    @Query(value = "", nativeQuery = true)
//    void currentToHourlyUsageTransfer();
}
