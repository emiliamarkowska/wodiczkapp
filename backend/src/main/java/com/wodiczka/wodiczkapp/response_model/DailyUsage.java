package com.wodiczka.wodiczkapp.response_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Map;

@NoArgsConstructor
public class DailyUsage {

    @JsonProperty("date")
    private Date date;

    @JsonProperty("totalyInDate")
    private Integer totalDayLiters;

    @JsonProperty("ratio")
    Map<String, String> ratioMap;

    public DailyUsage(Date date, Integer totalDayLiters, Map<String, String> ratioMap) {
        this.date = date;
        this.totalDayLiters = totalDayLiters;
        this.ratioMap = ratioMap;
    }

    public Date getLocalDateTime() {
        return this.date;
    }
}
