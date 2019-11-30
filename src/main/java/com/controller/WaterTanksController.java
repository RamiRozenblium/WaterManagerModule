package com.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.WaterTanksService;

@RestController
public class WaterTanksController {
	@Autowired
	WaterTanksService waterTanksService;

	@GetMapping("/max/{id}")
	BigDecimal getMaxCapacity(@PathVariable int id) {
		return waterTanksService.getMaxCapacity(id);
	}

	@GetMapping("/current/{idTank}")
	BigDecimal gerCurrentCapacity(@PathVariable int idTank) {
		return waterTanksService.getCurrentCapacity(idTank);
	}

	@PostMapping("/tank/{idTanks}/{liters}")
	boolean addWater(@PathVariable int idTanks, @PathVariable BigDecimal liters) {
		return waterTanksService.addWater(idTanks, liters);
	}
}
