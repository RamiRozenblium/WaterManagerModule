package com.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tank {

	int id;

	BigDecimal currentVolume;

	BigDecimal maxVolume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(BigDecimal currentVolume) {
		this.currentVolume = currentVolume;
	}

	public BigDecimal getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(BigDecimal maxVolume) {
		this.maxVolume = maxVolume;
	}

	public Tank(int id, BigDecimal maxVolume) {
		this.id = id;
		this.currentVolume = BigDecimal.ZERO;
		this.maxVolume = maxVolume;
	}

	public void leak() {
		if (BigDecimal.ZERO.compareTo(currentVolume) > -1) {
			currentVolume = BigDecimal.ZERO;

		} else {
			currentVolume = currentVolume
					.subtract(BigDecimal.ONE.divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP));

		}
	}

}
