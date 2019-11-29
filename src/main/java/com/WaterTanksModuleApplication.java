package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.service.WaterTankConfig;

@SpringBootApplication
@EnableScheduling
public class WaterTanksModuleApplication implements CommandLineRunner {

	@Autowired
	WaterTankConfig waterTankConfig;

	public static void main(String[] args) {
		SpringApplication.run(WaterTanksModuleApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		waterTankConfig.creatTanks();
	}

}
