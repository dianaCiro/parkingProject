package com.ceiba.builder;

import com.ceiba.domain.Receip;
import com.ceiba.entity.ReceipEntity;

public class ReceipBuilder {
	
	VehicleBuilder vehicleBuilder = new VehicleBuilder();
	public Receip  convertToDomain(ReceipEntity receipEntity) {
		Receip receip = null;
		
		if(receipEntity != null) {
			receip = new Receip(vehicleBuilder.convertToDomain(receipEntity.getVehicle()), receipEntity.getEntryTime(),
								receipEntity.getDepartureTime(), receipEntity.getPayment());
		}
		return receip;
	}
	
	public ReceipEntity convertToEntity(Receip receip) {
		ReceipEntity receipEntity = null;
		
			if(receip != null) {
				receipEntity = new ReceipEntity();
				receipEntity.setVehicle(vehicleBuilder.convertToEntity(receip.getVehicle()));
				receipEntity.setEntryTime(receip.getEntryTime());
				receipEntity.setDepartureTime(receip.getDepartureTime());
				receipEntity.setPayment(receip.getPayment());
			}
			
		return receipEntity;
	}
}
