package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.Usage;
import com.wodiczka.wodiczkapp.response_model.DailyUsage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UsageRepository extends CrudRepository<Usage, Integer> {

    @Query(value = "select count(*) from usages\n" +
            "where date(usages.date_time) = date(utc_timestamp())", nativeQuery = true)
    Integer getCurrentDayUsageInLiters();

    @Query(value = "select date(usages.date_time), count(*) from usages\n" +
            "where date(usages.date_time) <= date(utc_timestamp()) and\n" +
            "date(usages.date_time) > date(utc_timestamp() - interval :amount day)\n" +
            "group by date(usages.date_time)", nativeQuery = true)
    List<DailyUsage> getLatestDailyUsagesInLiters(@Param("amount") int amount);




//
//    @Query(value = "select round(sum(hourly_usages.sum), 2) from hourly_usages\n" +
//            "where year(hourly_usages.date_time) = (hour(:dateTime)) and\n" +
//            "month(hourly_usages.date_time) = (hour(:dateTime)) and\n" +
//            "day(hourly_usages.date_time) = (hour(:dateTime))", nativeQuery = true)
//    float getTotalCurrentDailyUsageInLiters(@Param("dateTime") LocalDateTime dateTime);
//
//
//    @Query(value = "select round(sum(current_usages_categories.rate), 2) from current_usages_categories\n" +
//            "join categories on categories.id = current_usages_categories.category_id\n" +
//            "join current_usages on current_usages.id = current_usages_categories.current_usage_id", nativeQuery = true)
//    float getTotalCurrentUsageInLiters();



}
