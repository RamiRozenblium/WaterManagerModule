package com.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class WaterTanksService implements IWaterTanks {
	static Map<Integer, AtomicInteger> tanks = new HashMap<Integer, AtomicInteger>();
	
	static {

		for (int i = 0; i < 10; i++) {
			tanks.put(i, new AtomicInteger(0));
		}
	}

	public static Map<Integer, AtomicInteger> getTanks() {
		return tanks;
	}

	AtomicInteger MAXCAPTANK = new AtomicInteger(50);

	@Override
	public int getMaxCapacity(int idTank) {

		return MAXCAPTANK.get();
	}

	@Override
	public int getCurrentCapacity(int idTank) {

		return tanks.get(idTank) == null ? 0 : tanks.get(idTank).get();

	}

	public void leakTank(int idTank) {
		AtomicInteger currentAtomic = tanks.get(idTank);
		int current = currentAtomic.get();
		int next = (int) ((double) current - 0.8);
		tanks.put(idTank, new AtomicInteger(next));
	}

	@Override
	public boolean addWater(int idTanks, int volumeOfLiters) {
		int current = getCurrentCapacity(idTanks);

		if (volumeOfLiters < 0) {
			volumeOfLiters = 0;
		}
		if ((current + volumeOfLiters) > getMaxCapacity(idTanks)) {
			return false;
		}

		tanks.put(idTanks, new AtomicInteger(current + volumeOfLiters));
		return true;
	}

}
