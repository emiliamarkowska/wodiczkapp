package com.wodiczka.wodiczkapp.response_model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class CategoriesResponse {
    @JsonProperty("sum_liters_in_current_hour")
    float sumLiters;
    @JsonProperty("mapped_categories_to_liters_in_current_hour")
    Map<String, Float> categoriesIdToLiters;

    public CategoriesResponse() {
        sumLiters = 0;
        categoriesIdToLiters = new HashMap<>();
    }

    public void putEntry(String categoryName, Float liters) {
        categoriesIdToLiters.put(categoryName, liters);
    }
    public void addLiters(float litersForCategory) {
        sumLiters += litersForCategory;
    }
}
