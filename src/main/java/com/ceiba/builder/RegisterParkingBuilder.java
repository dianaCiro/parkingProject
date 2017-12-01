package com.ceiba.builder;

import com.ceiba.domain.RegisterParking;
import com.ceiba.entity.RegisterParkingEntity;

public class RegisterParkingBuilder {
	
	VehicleBuilder vehicleBuilder = new VehicleBuilder();
	public RegisterParking  convertToDomain(RegisterParkingEntity receipEntity) {
		RegisterParking receip = null;
		
		if(receipEntity != null) {
			receip = new RegisterParking(vehicleBuilder.convertToDomain(receipEntity.getVehicle()), receipEntity.getEntryTime(),
								receipEntity.getDepartureTime(), receipEntity.getPayment());
		}
		return receip;
	}
	
	public RegisterParkingEntity convertToEntity(RegisterParking receip) {
		RegisterParkingEntity receipEntity = null;
		
			if(receip != null) {
				receipEntity = new RegisterParkingEntity();
				receipEntity.setVehicle(vehicleBuilder.convertToEntity(receip.getVehicle()));
				receipEntity.setEntryTime(receip.getEntryTime());
				receipEntity.setDepartureTime(receip.getDepartureTime());
				receipEntity.setPayment(receip.getPayment());
			}
			
		return receipEntity;
	}
}
