package com.wodiczka.wodiczkapp.response_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
public class DailyUsage {

    @JsonProperty("date")
    private Date date;

    @JsonProperty("totalyInDate")
    private Integer totalDayLiters;

    public DailyUsage(Date date, Integer totalDayLiters) {
        this.date = date;
        this.totalDayLiters = totalDayLiters;
    }

    public Date getLocalDateTime() {
        return this.date;
    }
}
