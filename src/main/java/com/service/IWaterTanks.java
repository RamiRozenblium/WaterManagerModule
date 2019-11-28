package com.service;

public interface IWaterTanks {

	int getMaxCapacity(int idTank);

	int getCurrentCapacity(int idTank);

	boolean addWater(int idTanks, int volumeOfLiters);

}
