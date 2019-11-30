package com.service;

import com.domain.Tank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class WaterTanksService implements IWaterTanks {

	Logger log =  LoggerFactory.getLogger(WaterTanksService.class);

	private Map<Integer, Tank> tanks;

	public Map<Integer, Tank> getTanks() {
		return tanks;
	}

	@Override
	public BigDecimal getMaxCapacity(int id) {
		if (!tanks.containsKey(id)) {
			log.error("id does not exist");
			throw new RuntimeException("id does not exist");
		}
		return tanks.get(id).getMaxVolume();
	}

	@Override
	public BigDecimal getCurrentCapacity(int id) {
		if (!tanks.containsKey(id)) {
			log.error("id does not exist");
			throw new RuntimeException("id does not exist");
		}
		return tanks.get(id).getCurrentVolume();

	}

	@Override
	public synchronized boolean addWater(int id, BigDecimal volumeOfLiters) {

		if (!tanks.containsKey(id)) {
			log.error("id does not exist");
			throw new RuntimeException("id does not exist");
		}
		if (BigDecimal.ZERO.compareTo(volumeOfLiters) > -1) {
			log.error("volume is invalid");
			throw new RuntimeException("volume is invalid");
		}
		Tank tank = tanks.get(id);
		BigDecimal previous = tank.getCurrentVolume();

		if (previous.add(volumeOfLiters).compareTo(tank.getMaxVolume()) > 0) {
			return false;
		}
		tank.setCurrentVolume(previous.add(volumeOfLiters));
		return true;
	}

	public void createTanks(int capacityOfTanks, double maxVolumeOfTank) {
		this.tanks = new ConcurrentHashMap<>(capacityOfTanks);
		for (int i = 0; i < capacityOfTanks; i++) {
			this.tanks.put(i, new Tank(i, BigDecimal.valueOf(maxVolumeOfTank)));
		}
	}
}
