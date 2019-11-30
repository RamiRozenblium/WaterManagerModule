package com;

import com.service.WaterTanksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

class WaterTanksModuleApplicationTests {

	@Test()
	void testNoTanks() {
		WaterTanksService waterService = new WaterTanksService();
		waterService.createTanks(0, 0);

		assertTrue(waterService.getTanks().size() == 0);
	}

	@Test()
	void testTankNotExist() {
		WaterTanksService waterService = new WaterTanksService();
		waterService.createTanks(0, 0);

		Throwable thrown = Assertions.assertThrows(RuntimeException.class,
				() -> waterService.addWater(0, BigDecimal.valueOf(0)));

		assertTrue(thrown.getMessage().contains("id does not exist"));
	}

	@Test()
	void testIvalidValue() {
		WaterTanksService waterService = new WaterTanksService();
		waterService.createTanks(1, 0);

		Throwable thrown = Assertions.assertThrows(RuntimeException.class,
				() -> waterService.addWater(0, BigDecimal.valueOf(-1)));

		assertTrue(thrown.getMessage().contains("volume is invalid"));
	}

	@Test()
	void testOverloadTank() {
		WaterTanksService waterService = new WaterTanksService();
		waterService.createTanks(1, 50);
		Assertions.assertFalse(waterService.addWater(0, BigDecimal.valueOf(60)));
	}

	@Test()
	void testMaxCapacity() {
		WaterTanksService waterService = new WaterTanksService();
		waterService.createTanks(1, 50);
		waterService.addWater(0, BigDecimal.valueOf(50));
		Assertions.assertEquals(BigDecimal.valueOf(50.0), waterService.getMaxCapacity(0));

	}

}
