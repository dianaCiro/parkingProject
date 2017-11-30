package com.ceiba.builder;

import com.ceiba.domain.Vehicle;
import com.ceiba.entity.VehicleEntity;

public class VehicleBuilder {
	
	private String numberPlate;
	private int cylinder;
	private String brand;
	private String vehicleType;
	
	public VehicleBuilder() {}
	
	public Vehicle convertToDomain(VehicleEntity vehicleEntity) {
		Vehicle vehicle = null;
		if(vehicleEntity != null) {
			numberPlate = vehicleEntity.getNumberPlate();
			cylinder = vehicleEntity.getCylinder();
			brand = vehicleEntity.getBrand();
			vehicleType = vehicleEntity.getVehicleType();
			vehicle = new Vehicle(numberPlate, cylinder, brand, vehicleType);
		}
		return vehicle;
	}
	
	public VehicleEntity convertToEntity(Vehicle vehicle) {
		VehicleEntity vehicleEntity = null;
		if(vehicle != null) {
			vehicleEntity = new VehicleEntity();
			vehicleEntity.setNumberPlate(vehicle.getNumberPlate());
			vehicleEntity.setCylinder(vehicle.getCylinder());
			vehicleEntity .setBrand(vehicle.getBrand());
			vehicleEntity.setVehicleType(vehicle.getVehicleType()); 
		}
		return vehicleEntity;
	}
}
