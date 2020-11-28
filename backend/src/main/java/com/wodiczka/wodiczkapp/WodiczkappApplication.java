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
}
