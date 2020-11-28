package com.wodiczka.wodiczkapp.services;

import com.wodiczka.wodiczkapp.model.ActiveCategory;
import com.wodiczka.wodiczkapp.model.Category;
import com.wodiczka.wodiczkapp.model.CurrentUsage;
import com.wodiczka.wodiczkapp.model.CurrentUsageCategory;
import com.wodiczka.wodiczkapp.repositories.CategoryRepository;
import com.wodiczka.wodiczkapp.repositories.CurrentUsageCategoryRepository;
import com.wodiczka.wodiczkapp.repositories.CurrentUsageRepository;
import com.wodiczka.wodiczkapp.response_model.CategoriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentUsageService {
    private CurrentUsageRepository currentUsageRepository;
    private ActiveCategoryService activeCategoryService;
    private CurrentUsageCategoryRepository currentUsageCategoryRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public CurrentUsageService(CurrentUsageRepository currentUsageRepository,
                               ActiveCategoryService activeCategoryService,
                               CurrentUsageCategoryRepository currentUsageCategoryRepository,
                               CategoryRepository categoryRepository) {
        this.currentUsageRepository = currentUsageRepository;
        this.activeCategoryService = activeCategoryService;
        this.currentUsageCategoryRepository = currentUsageCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public void addCurrentUsage(CurrentUsage currentUsage) {
        List<ActiveCategory> activeCategoryList = activeCategoryService.getActiveCategories();
        float weightSum = getWeightSum(activeCategoryList);
        List<CurrentUsageCategory> currentUsageCategories = getCurrentUsageCategories(activeCategoryList, currentUsage, weightSum);
        currentUsageRepository.save(currentUsage);
        currentUsageCategoryRepository.saveAll(currentUsageCategories);
    }

    public CategoriesResponse getCategoriesToLiters() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        CategoriesResponse categoriesResponse = new CategoriesResponse();
        categories.forEach(category -> {
            Integer categoryId = category.getId();
            String categoryName = category.getName();
            float liters = currentUsageRepository.getCurrentUsageInLiters(categoryId);
            categoriesResponse.putEntry(categoryName, liters);
            categoriesResponse.addLiters(liters);
        });
        return categoriesResponse;
    }

    private float getWeightSum(List<ActiveCategory> activeCategories) {
        float weightSum = 0;
        for (ActiveCategory activeCategory : activeCategories) {
            weightSum += activeCategory.getCategory().getRate();
        }
        return weightSum;
    }

    private List<CurrentUsageCategory> getCurrentUsageCategories(List<ActiveCategory> activeCategories, CurrentUsage currentUsage, float weightSum) {
        List<CurrentUsageCategory> currentUsageCategories = new ArrayList<>();
        for (ActiveCategory activeCategory : activeCategories) {
            float rateForCurrentUsage = activeCategory.getCategory().getRate() / weightSum;
            currentUsageCategories.add(new CurrentUsageCategory(activeCategory.getCategory(), currentUsage, rateForCurrentUsage));
        }
        return currentUsageCategories;
    }


    public void deleteCurrentUsage(int id) {
        currentUsageRepository.deleteById(id);
    }
}
