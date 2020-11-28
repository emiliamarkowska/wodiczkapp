package com.wodiczka.wodiczkapp.response_model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
public class DailyUsage {
    @Getter
    @Setter
    private LocalDateTime date;
    @Getter
    @Setter
    private Integer totalDayLiters;

    public DailyUsage( LocalDateTime date, Integer totalDayLiters) {
        this.date = date;
        this.totalDayLiters = totalDayLiters;
    }


}
