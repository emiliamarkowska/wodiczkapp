package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.ActiveCategory;
import com.wodiczka.wodiczkapp.model.Category;
import com.wodiczka.wodiczkapp.model.Usage;
import com.wodiczka.wodiczkapp.repositories.UsageRepository;
import com.wodiczka.wodiczkapp.response_model.CategoriesResponse;
import com.wodiczka.wodiczkapp.response_model.CurrentDayResponse;
import com.wodiczka.wodiczkapp.response_model.DailyUsage;
import com.wodiczka.wodiczkapp.response_model.DaysResponse;
import org.hibernate.hql.internal.ast.tree.MapEntryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (DailyUsage dailyUsage : usageRepository.getLatestDailyUsagesInLiters(amount)) {
            totalDaysLiters += dailyUsage.getTotalDayLiters();
            dailyUsages.add(new DailyUsage(dailyUsage.getDate(), dailyUsage.getTotalDayLiters()));
        }

        return new DaysResponse(totalDaysLiters, dailyUsages);
    }
}
