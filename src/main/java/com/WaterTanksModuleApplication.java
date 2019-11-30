package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.service.WaterTanksConfig;
import com.service.WaterTanksService;

@SpringBootApplication
@EnableScheduling
public class WaterTanksModuleApplication implements CommandLineRunner {

	@Autowired
	WaterTanksService waterTankService;
	
	@Autowired
	WaterTanksConfig config;
	
	public static void main(String[] args) {
		SpringApplication.run(WaterTanksModuleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		waterTankService.createTanks(config.getCapacityOfTanks(), config.getMaxVolumeOfTank());
	}
}
