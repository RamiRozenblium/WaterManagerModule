package com;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.domain.Tank;
import com.service.WaterTanksService;

@Component
public class LeakWaterTask {

	@Autowired
	WaterTanksService waterTanksService;

	@Scheduled(fixedRate = 1000)
	public void leak() {
		Map<Integer, Tank> waterTanks = waterTanksService.getTanks();
		if (waterTanks != null) {
			waterTanks.entrySet().parallelStream().forEach(k -> k.getValue().leak());
		}
	}
}
