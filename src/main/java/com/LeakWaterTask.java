package com;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.service.WaterTanksService;

@Component
public class LeakWaterTask {

	@Autowired
	WaterTanksService waterTanksService;

	@Scheduled(fixedRate = 1000)
	public void leak() {

		Map<Integer, AtomicInteger> waterTanks = WaterTanksService.getTanks();

		waterTanks.keySet().parallelStream().forEach(k -> {
			int current = waterTanksService.getCurrentCapacity(k);

			if (current != 0) {
				waterTanksService.leakTank(k);
			}

			System.out.println(current);
		});
	}
}
