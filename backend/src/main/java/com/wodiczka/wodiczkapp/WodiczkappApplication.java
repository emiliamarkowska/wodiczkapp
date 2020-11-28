package com.wodiczka.wodiczkapp;

import com.wodiczka.wodiczkapp.model.*;
import com.wodiczka.wodiczkapp.repositories.CategoryRepository;
import com.wodiczka.wodiczkapp.repositories.UsageRepository;
import com.wodiczka.wodiczkapp.repositories.CurrentUsageCategoryRepository;
import com.wodiczka.wodiczkapp.repositories.CurrentUsageRepository;
import com.wodiczka.wodiczkapp.repositories.HourlyUsageRepository;
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
	public CommandLineRunner testDataUsages(UsageRepository usageRepository) {
		return args -> {
			usageRepository.save(new Usage(LocalDateTime.now().minusDays(10)));
			usageRepository.save(new Usage(LocalDateTime.now().minusDays(7)));
			usageRepository.save(new Usage(LocalDateTime.now().minusDays(3)));
			usageRepository.save(new Usage(LocalDateTime.now().minusDays(1).minusHours(4)));
			usageRepository.save(new Usage(LocalDateTime.now().minusDays(1).minusHours(2)));
			usageRepository.save(new Usage(LocalDateTime.now().minusHours(20)));
			usageRepository.save(new Usage(LocalDateTime.now().minusHours(10)));
			usageRepository.save(new Usage(LocalDateTime.now().minusHours(6)));
			usageRepository.save(new Usage(LocalDateTime.now().minusHours(6).minusMinutes(30)));
			usageRepository.save(new Usage(LocalDateTime.now().minusMinutes(50)));
			usageRepository.save(new Usage(LocalDateTime.now().minusMinutes(30)));
			usageRepository.save(new Usage(LocalDateTime.now().minusMinutes(10)));
			usageRepository.save(new Usage(LocalDateTime.now().minusMinutes(5)));
			usageRepository.save(new Usage(LocalDateTime.now()));
		};
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
	@Bean
	public CommandLineRunner testDataHourlyUsage(HourlyUsageRepository hourlyUsageRepository) {
		return args -> {
			hourlyUsageRepository.save(new HourlyUsage(LocalDateTime.now(), 30, category1));
			hourlyUsageRepository.save(new HourlyUsage(LocalDateTime.now(), 30, category1));
			hourlyUsageRepository.save(new HourlyUsage(LocalDateTime.now(), 30, category2));
		};
	}


}
