package com.ceiba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.entity.VehicleEntity;
import com.ceiba.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	 VehicleService vehicleService;
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public List<VehicleEntity> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

    @RequestMapping(value = "/vehicle/{plate}", method = RequestMethod.GET)
    public VehicleEntity getVehicle(@PathVariable("plate") String plate) {
		return vehicleService.getVehicleByPlate(plate);
	}
    
    @RequestMapping(value = "/createVehicle", method = RequestMethod.POST)
    public void saveVehicle(@RequestBody VehicleEntity vehicleEntity) {
		vehicleService.insertVehicle(vehicleEntity);
	}
    
}
