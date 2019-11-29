package com.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource
public class WaterTankConfig {

	@Value("${capacity.value}")
	double capacityOfTanks;

	@Value("${volume.value}")
	double volumeOfTank;

	@ManagedAttribute
	public double getCapacityOfTanks() {
		return capacityOfTanks;
	}

	@ManagedAttribute
	public double getVolumeOfTank() {

		return volumeOfTank;
	}

	Map<Integer, Double> tanks = new ConcurrentHashMap<Integer, Double>();

	public Map<Integer, Double> creatTanks() {

		for (int i = 0; i < capacityOfTanks; i++) {
			tanks.put(i, 0.0);
		}

		return tanks;
	}

	public Map<Integer, Double> getTanks() {

		return this.tanks;
	}

	public double getMaxCapacity(int id) {

		return volumeOfTank;
	}

}
