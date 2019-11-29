package com.controller;

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

	@GetMapping("/max/tank/{id}")
	double getMaxCapacity(@PathVariable int id) {
		return waterTanksService.getMaxCapacity(id);

	}

	@GetMapping("/current/tank/{idTank}")
	double gerCurrentCapacity(@PathVariable int idTank) {
		return waterTanksService.getCurrentCapacity(idTank);
	}

	@PostMapping("/tank/{idTanks}/{liters}")
	boolean addWater(@PathVariable int idTanks, @PathVariable double liters) {
		return waterTanksService.addWater(idTanks, liters);
	}
}
