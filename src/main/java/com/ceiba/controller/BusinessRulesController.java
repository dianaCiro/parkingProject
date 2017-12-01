package com.ceiba.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.domain.VehiclesInParking;
import com.ceiba.entity.VehicleEntity;
import com.ceiba.service.BusinessRulesService;


@RestController
public class BusinessRulesController {

	@Autowired
	@Qualifier("businesServiceQua")
	BusinessRulesService businessService;

	@RequestMapping(value = "/registers", method = RequestMethod.GET)
	public List<VehiclesInParking> getAllRegisters() {
		return businessService.getAllVehicles();
	}

	@RequestMapping(value = "/createRegister", method = RequestMethod.POST)
	public void saveVehicle(@RequestBody VehicleEntity vehicleEntity) {
		businessService.registerEntryVehicle(vehicleEntity);
	}

	@RequestMapping(value = "/updateRegister", method = RequestMethod.POST)
	public void updateVehicle(@RequestBody VehicleEntity vehicleEntity) {
		businessService.registerDepartureVehicle(vehicleEntity);
	}
}
