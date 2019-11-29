package com.service;

public interface IWaterTanks {

	double getMaxCapacity(int id);

	double getCurrentCapacity(int idTank);

	boolean addWater(int idTanks, double volumeOfLiters);

}
