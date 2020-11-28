package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.AnnualUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AnnualUsageRepository extends CrudRepository<AnnualUsage, Integer> {
    @Query(value = "select round(sum(annual_usages.sum), 2) from annual_usages\n" +
            "where annual_usages.category_id = :categoryId and \n" +
            "year(annual_usages.date) = (hour(:dateTime))", nativeQuery = true)
    float getAnnualUsageInLiters(@Param("categoryId") Integer categoryId,
                                  @Param("dateTime") LocalDateTime dateTime);
}
