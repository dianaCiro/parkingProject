package com.ceiba.service;

import java.util.List;

import com.ceiba.entity.VehicleEntity;


public interface VehicleService {
	VehicleEntity getVehicleByPlate(String numberPlate);
	List<VehicleEntity> getAllVehicles();
	void insertVehicle(VehicleEntity vehicleEntity);
	
}
