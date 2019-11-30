package com.service;

import java.math.BigDecimal;

public interface IWaterTanks {

	BigDecimal getMaxCapacity(int id);

	BigDecimal getCurrentCapacity(int idTank);

	boolean addWater(int idTanks, BigDecimal volumeOfLiters);

}
