package com.ceiba.service;

import java.util.List;

import com.ceiba.entity.ParkingEntity;

public interface ParkingService {
	ParkingEntity getParkingByName(String name);
	List<ParkingEntity> getAllParking();
	void insertParking(ParkingEntity parkingEntity);
}
