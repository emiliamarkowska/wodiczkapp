package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.Usage;
import com.wodiczka.wodiczkapp.repositories.UsageRepository;
import com.wodiczka.wodiczkapp.response_model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UsageService {
    private UsageRepository usageRepository;

    double polandDrought = 1000000 / 365 * 92 / 3900;
    double polandNormal = 1800000 / 365 * 92 / 3900;
    double europe = 4500000 / 365 * 92 / 3900;

    @Autowired
    public UsageService(UsageRepository usageRepository) {
        this.usageRepository = usageRepository;
    }

    public void addUsage(Usage usage) {
        usageRepository.save(usage);
    }

    public void deleteUsage(int id) {
        usageRepository.deleteById(id);
    }

    public CurrentDayResponse getCurrentDayUsage() {
        int totalLiters = usageRepository.getCurrentDayUsageInLiters();
        Map<String, String> ratioMap = new HashMap<>();
        ratioMap.put("europe", new DecimalFormat("#0.000").format(totalLiters / europe));
        ratioMap.put("poland-normal", new DecimalFormat("#0.000").format(totalLiters / polandNormal));
        ratioMap.put("poland-draught", new DecimalFormat("#0.000").format(totalLiters / polandDrought));
        return new CurrentDayResponse(totalLiters, ratioMap, LocalDateTime.now());
    }

    public DaysResponse getDaysUsage(int amount) {

        List<DailyUsage> dailyUsages = new ArrayList<>();
        int totalDaysLiters = 0;
        List<UsageRepository.IUsageDaily2> usages = usageRepository.getLatestDailyUsagesInLiters(amount);



        for(UsageRepository.IUsageDaily2 u : usages) {
            totalDaysLiters += u.getSecond().intValue();

            Map<String, String> ratioMap = new HashMap<>();
            ratioMap.put("europe", new DecimalFormat("#0.000").format(u.getSecond().intValue() / europe));
            ratioMap.put("poland-normal", new DecimalFormat("#0.000").format(u.getSecond().intValue() / polandNormal));
            ratioMap.put("poland-draught", new DecimalFormat("#0.000").format(u.getSecond().intValue() / polandDrought));

            dailyUsages.add(new DailyUsage(u.getFirst(), u.getSecond().intValue(), ratioMap));
        }

/*
        List<Date> datesInRange = new ArrayList<>();
        Date todayDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        for(int i = 0; i <= amount; i++) {
            datesInRange.add(addDays(todayDate, i));
        }

        datesInRange.stream()
                .map(date -> )

*/


        return new DaysResponse(totalDaysLiters, dailyUsages);
    }

    private static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }

}
