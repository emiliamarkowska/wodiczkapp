package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.DailyUsageTest;
import com.wodiczka.wodiczkapp.model.Usage;
import com.wodiczka.wodiczkapp.response_model.DailyUsage;
import com.wodiczka.wodiczkapp.response_model.IUsageDaily;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UsageRepository extends CrudRepository<Usage, Integer> {

    @Query(value = "select count(*) from usages\n" +
            "where date(usages.date_time) = date(utc_timestamp())", nativeQuery = true)
    Integer getCurrentDayUsageInLiters();

    @Query(value = "select date(u.date_time) as first, count(u.id) as second from usages u " +
            "where date(u.date_time) <= date(utc_timestamp()) and " +
            "date(u.date_time) > date(utc_timestamp() - interval :amount day) " +
            "group by date(u.date_time)", nativeQuery = true)
    List<IUsageDaily2> getLatestDailyUsagesInLiters(@Param("amount") int amount);

    public static interface IUsageDaily2 {

        Date getFirst();

        BigInteger getSecond();

    }



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
