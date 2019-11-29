package com;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.service.WaterTankConfig;
import com.service.WaterTanksService;

@Component
public class LeakWaterTask {

	@Autowired
	WaterTanksService waterTanksService;
	
	@Autowired
	WaterTankConfig waterTankConfig;
	
	
	@Scheduled(fixedRate = 1000)
	public void leak() {

		Map<Integer, Double> waterTanks = waterTankConfig.getTanks();

		waterTanks.keySet().parallelStream().forEach(k -> {
			double current = waterTanksService.getCurrentCapacity(k);

			if (current > 0) {
				waterTanksService.leakTank(k);
			}

			System.out.println(current);
		});
	}
}
