package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.MonthlyUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MonthlyUsageRepository extends CrudRepository<MonthlyUsage, Integer> {
    @Query(value = "select round(sum(monthly_usages.sum), 2) from monthly_usages\n" +
            "where monthly_usages.category_id = :categoryId and \n" +
            "year(monthly_usages.date) = (hour(:dateTime)) and\n" +
            "month(monthly_usages.date) = (hour(:dateTime))", nativeQuery = true)
    float getMonthlyUsageInLiters(@Param("categoryId") Integer categoryId,
                                @Param("dateTime") LocalDateTime dateTime);
}
