package com.widoczka.wodiczkapp;

import com.widoczka.wodiczkapp.model.Category;
import com.widoczka.wodiczkapp.model.CurrentUsage;
import com.widoczka.wodiczkapp.model.CurrentUsageCategory;
import com.widoczka.wodiczkapp.repositories.CategoryRepository;
import com.widoczka.wodiczkapp.repositories.CurrentUsageCategoryRepository;
import com.widoczka.wodiczkapp.repositories.CurrentUsageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class WodiczkappApplication {

	Category category1 = new Category("Shower", 2.0f);
	Category category2 = new Category("Bath", 5.0f);
	Category category3 = new Category("Washing Machine", 0.5f);
	Category category4 = new Category("Dishwasher", 0.7f);

	CurrentUsage currentUsage1 = new CurrentUsage(LocalDateTime.now());
	CurrentUsage currentUsage2 = new CurrentUsage(LocalDateTime.now());
	CurrentUsage currentUsage3 = new CurrentUsage(LocalDateTime.now());
	CurrentUsage currentUsage4 = new CurrentUsage(LocalDateTime.now());
	CurrentUsage currentUsage5 = new CurrentUsage(LocalDateTime.now());

	public static void main(String[] args) {
		SpringApplication.run(WodiczkappApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDataCategory(CategoryRepository categoryRepository) {
		return args -> {
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
		};
	}
	@Bean
	public CommandLineRunner testDataCurrentUsage(CurrentUsageRepository currentUsageRepository) {
		return args -> {
			currentUsageRepository.save(currentUsage1);
			currentUsageRepository.save(currentUsage2);
			currentUsageRepository.save(currentUsage3);
			currentUsageRepository.save(currentUsage4);
			currentUsageRepository.save(currentUsage5);
		};
	}
	@Bean
	public CommandLineRunner testDataCurrentUsageCategory(CurrentUsageCategoryRepository currentUsageCategoryRepository) {
		return args -> {
			currentUsageCategoryRepository.save(new CurrentUsageCategory(category1, currentUsage1, 0.5f));
			currentUsageCategoryRepository.save(new CurrentUsageCategory(category2, currentUsage1, 0.5f));

			currentUsageCategoryRepository.save(new CurrentUsageCategory(category2, currentUsage2, 0.2f));
			currentUsageCategoryRepository.save(new CurrentUsageCategory(category3, currentUsage2, 0.8f));

			currentUsageCategoryRepository.save(new CurrentUsageCategory(category1, currentUsage3, 0.5f));
			currentUsageCategoryRepository.save(new CurrentUsageCategory(category2, currentUsage3, 0.3f));
			currentUsageCategoryRepository.save(new CurrentUsageCategory(category3, currentUsage3, 0.2f));

			currentUsageCategoryRepository.save(new CurrentUsageCategory(category4, currentUsage4, 1.0f));

			currentUsageCategoryRepository.save(new CurrentUsageCategory(category1, currentUsage5, 0.5f));
			currentUsageCategoryRepository.save(new CurrentUsageCategory(category4, currentUsage5, 0.5f));
		};
	}

}
