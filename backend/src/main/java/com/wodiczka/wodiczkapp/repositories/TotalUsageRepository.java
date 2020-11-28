package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.TotalUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface TotalUsageRepository extends CrudRepository<TotalUsage, Integer> {
    @Query(value = "select round(sum(total_usages.sum), 2) from total_usages\n" +
            "where annual_usages.category_id = :categoryId", nativeQuery = true)
    float getTotalUsageInLiters(@Param("categoryId") Integer categoryId);
}
