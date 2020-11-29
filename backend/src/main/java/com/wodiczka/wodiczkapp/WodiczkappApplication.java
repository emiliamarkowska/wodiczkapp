package com.wodiczka.wodiczkapp;

import com.wodiczka.wodiczkapp.model.*;
import com.wodiczka.wodiczkapp.repositories.UsageRepository;
import com.wodiczka.wodiczkapp.repositories.CurrentUsageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.LocalDate;

@SpringBootApplication
public class WodiczkappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WodiczkappApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadUsageData(UsageRepository usageRepository) {
		return args -> {
			LocalDate d = LocalDate.now();
			LocalDateTime dt = d.atStartOfDay();
			LocalDateTime now = LocalDateTime.now();

			for (int i = 20; i > 1; --i) {
				LocalDateTime start = dt.minusDays(i);
				for (int j = 1; j < (i % 2) * 30 + (i % 3) * 15 + (i % 4) * 9 + (i % 5) * 3;  ++j) {
					usageRepository.save(new Usage(start.plusMinutes(j)));
				}
			}

			for (int i = 58; i > 1; --i) {
				usageRepository.save(new Usage(now.minusMinutes(i)));
			}
		};
	}
}
