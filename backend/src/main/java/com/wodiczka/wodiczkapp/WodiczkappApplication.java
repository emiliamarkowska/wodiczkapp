package com.wodiczka.wodiczkapp;

import com.wodiczka.wodiczkapp.model.*;
import com.wodiczka.wodiczkapp.repositories.UsageRepository;
import com.wodiczka.wodiczkapp.repositories.CurrentUsageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class WodiczkappApplication {

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
	public CommandLineRunner testDataCurrentUsage(CurrentUsageRepository currentUsageRepository) {
		return args -> {
			currentUsageRepository.save(currentUsage1);
			currentUsageRepository.save(currentUsage2);
			currentUsageRepository.save(currentUsage3);
			currentUsageRepository.save(currentUsage4);
			currentUsageRepository.save(currentUsage5);
		};
	}
}
