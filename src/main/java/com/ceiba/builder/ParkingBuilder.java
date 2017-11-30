package com.ceiba.builder;

import com.ceiba.domain.Parking;
import com.ceiba.entity.ParkingEntity;

public class ParkingBuilder {
	
	private String name;
	private int carCapacity;
	private int motorcycleCapacity;
	private int carHourValue;
	private int motorcycleHourValue;
	private int carDayValue;
	private int motorcycleDayValue;
	
	public ParkingBuilder() {	}
	
	public Parking convertToDomain(ParkingEntity parkingEntity) {
		
		Parking parking = null;
		
		if (parkingEntity != null) {
			name = parkingEntity.getName();
			carCapacity = parkingEntity.getCarCapacity();
			motorcycleCapacity = parkingEntity.getMotorcycleCapacity();
			carHourValue = parkingEntity.getCarHourValue();
			motorcycleHourValue = parkingEntity.getMotorcycleHourValue();
			carDayValue = parkingEntity.getCarDayValue();
			motorcycleDayValue = parkingEntity.getMotorcycleDayValue();
			parking = new Parking(name, carCapacity, motorcycleCapacity, carHourValue, 
					motorcycleHourValue, carDayValue, motorcycleDayValue);
		}
		
		
		return parking;
	}
	
	public ParkingEntity convertToEntity(Parking parking) {
			
			ParkingEntity parkingEntity = null;
			
			if (parking != null) {
				parkingEntity = new ParkingEntity();
				parkingEntity.setName(parking.getName());
				parkingEntity.setCarCapacity(parking.getCarCapacity());
				parkingEntity.setMotorcycleCapacity(parking.getMotorcycleCapacity());
				parkingEntity.setCarHourValue(parking.getCarHourValue());
				parkingEntity.setMotorcycleHourValue(parking.getMotorcycleHourValue());
				parkingEntity.setCarDayValue(parking.getCarDayValue());
				parkingEntity.setMotorcycleDayValue(parking.getMotorcycleDayValue());
				
			}
			
			
			return parkingEntity;
		}
	
}
