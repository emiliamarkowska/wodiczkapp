package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.Usage;
import com.wodiczka.wodiczkapp.repositories.UsageRepository;
import com.wodiczka.wodiczkapp.response_model.*;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
        Map<String, Double> ratioMap = new HashMap<>();
        double europeValue = DoubleRounder.round(totalLiters / europe, 3);
        double polandNormalValue = DoubleRounder.round(totalLiters / polandNormal, 3);
        double polandDroughtValue = DoubleRounder.round(totalLiters/polandDrought, 3);
        ratioMap.put("europe", europeValue);
        ratioMap.put("polandNormal", polandNormalValue);
        ratioMap.put("polandDraught", polandDroughtValue);
        double totalLitersDouble = totalLiters;
        double averageLiters = 92;
        double ratio = DoubleRounder.round(totalLitersDouble/averageLiters, 3);
        return new CurrentDayResponse(totalLiters, ratioMap, LocalDateTime.now(), ratio, averageLiters);
    }

    public DaysResponse getDaysUsage(int amount) {

        List<DailyUsage> dailyUsages = new ArrayList<>();
        int totalDaysLiters = 0;
        List<UsageRepository.IUsageDaily2> usages = usageRepository.getLatestDailyUsagesInLiters(amount);

        for (UsageRepository.IUsageDaily2 u : usages) {
            totalDaysLiters += u.getSecond().intValue();

            Map<String, Double> ratioMap = new HashMap<>();
            double europeValue = DoubleRounder.round(u.getSecond().intValue() / europe, 3);
            double polandNormalValue = DoubleRounder.round(u.getSecond().intValue() / polandNormal, 3);
            double polandDraughtValue = DoubleRounder.round(u.getSecond().intValue() / polandDrought, 3);
            ratioMap.put("europe", europeValue);
            ratioMap.put("polandNormal", polandNormalValue);
            ratioMap.put("polandDraught", polandDraughtValue);

            dailyUsages.add(new DailyUsage(u.getFirst(), u.getSecond().intValue(), ratioMap));
        }


        List<Date> datesInRange = new ArrayList<>();
        Date todayDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        for (int i = 0; i <= amount; i++) {
            datesInRange.add(substractDays(todayDate, i));
        }

        List<DailyUsage> notPresentDailyUsages = datesInRange.stream()
                .filter(date -> !isDatePresent(dailyUsages, date))
                .map(date -> {
                    Map<String, Double> ratioMap = new HashMap<>();
                    ratioMap.put("europe", (double) 0);
                    ratioMap.put("polandNormaln", (double) 0);
                    ratioMap.put("polandDraught", (double) 0);

                    Integer total = 0;
                    return new DailyUsage(date, total, ratioMap);
                })
                .collect(Collectors.toList());
        dailyUsages.addAll(notPresentDailyUsages);
        List<DailyUsage> dailyUsageList = dailyUsages.stream()
                .sorted(Comparator.comparing(DailyUsage::getLocalDateTime))
                .collect(Collectors.toList());
        return new DaysResponse(totalDaysLiters, dailyUsageList);
    }

    private boolean isDatePresent(List<DailyUsage> dailyUsages, Date date) {
        boolean x = dailyUsages.stream()
                .map(dailyUsage -> dailyUsage.getLocalDateTime().toLocalDate())
                .collect(Collectors.toList())
                .contains(date.toLocalDate());
        return x;
    }

    private static Date substractDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -days);
        return new Date(c.getTimeInMillis());
    }

}
