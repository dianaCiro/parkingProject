package com.ceiba.service;

import java.util.List;
import com.ceiba.domain.VehiclesInParking;
import com.ceiba.entity.VehicleEntity;

public interface BusinessRulesService {

	int getTotalCarInParking();
	int getTotalMotorcycleInParking();
	String registerEntryVehicle(VehicleEntity vehicleEntity);
	String registerDepartureVehicle(VehicleEntity vehicleEntity);
	List<VehiclesInParking> getAllVehicles();
}
