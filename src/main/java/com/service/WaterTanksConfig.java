package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource
public class WaterTanksConfig {

	@Value("${capacity.value}")
	private int capacityOfTanks;

	@Value("${maxVolume.value}")
	private double maxVolumeOfTank;

	@ManagedAttribute
	public int getCapacityOfTanks() {
		return capacityOfTanks;
	}

	@ManagedAttribute
	public double getMaxVolumeOfTank() {

		return maxVolumeOfTank;
	}
}
