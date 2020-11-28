package com.wodiczka.wodiczkapp.response_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

public class CurrentDayResponse {
    @JsonProperty("totalDayLiters")
    Integer totalDayLiters;
    @JsonProperty("ratio")
    Map<String, Double> ratioMap;
    @Setter
    @JsonProperty("date")
    LocalDateTime localDateTime;
    @JsonProperty("ratioAverageUsage")
    double ratioAverageUsage;
    @JsonProperty("averageUsage")
    double averageUsage;

    public CurrentDayResponse(Integer totalDayLiters, Map<String, Double> ratioMap, LocalDateTime localDateTime, double ratioAverageUsage, double averageUsage) {
        this.totalDayLiters = totalDayLiters;
        this.ratioMap = ratioMap;
        this.localDateTime = localDateTime;
        this.ratioAverageUsage = ratioAverageUsage;
        this.averageUsage = averageUsage;
    }
}
