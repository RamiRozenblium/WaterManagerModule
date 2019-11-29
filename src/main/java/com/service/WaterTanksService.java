package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterTanksService implements IWaterTanks {

	@Autowired
	WaterTankConfig waterTankConf;

	public void leakTank(int idTank) {
		double current = waterTankConf.getTanks().get(idTank);
		double next = current - 0.8;
		if (next < 0) {
			next = 0;
		}
		waterTankConf.getTanks().put(idTank, next);
	}

	@Override
	public double getMaxCapacity(int id) {

		return waterTankConf.getMaxCapacity(id);
	}

	@Override
	public double getCurrentCapacity(int idTank) {

		return Math.round(waterTankConf.getTanks().get(idTank) * 10.0) / 10.0;

	}

	@Override
	public synchronized boolean addWater(int idTanks, double volumeOfLiters) {
		double current = getCurrentCapacity(idTanks);

		if (volumeOfLiters < 0) {
			volumeOfLiters = 0;
		}
		if ((current + volumeOfLiters) > getMaxCapacity(idTanks)) {
			return false;
		}

		waterTankConf.getTanks().put(idTanks, current + volumeOfLiters);
		return true;
	}

}
