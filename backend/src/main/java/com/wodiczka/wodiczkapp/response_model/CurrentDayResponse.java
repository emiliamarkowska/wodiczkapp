package com.wodiczka.wodiczkapp.response_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

public class CurrentDayResponse {
    @JsonProperty("totalDayLiters")
    Integer totalDayLiters;
    @JsonProperty("ratio")
    Map<String, String> ratioMap;
    @Setter
    @JsonProperty("date")
    LocalDateTime localDateTime;

    public CurrentDayResponse(Integer totalDayLiters, Map<String, String> ratioMap, LocalDateTime localDateTime) {
        this.totalDayLiters = totalDayLiters;
        this.ratioMap = ratioMap;
        this.localDateTime = localDateTime;
    }
}
