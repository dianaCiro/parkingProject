package com.ceiba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entity.ParkingEntity;
import com.ceiba.repository.ParkingRepository;
import com.ceiba.service.ParkingService;

@Service("parkingService")
public class ParkingServiceIm implements ParkingService{

	@Autowired
	ParkingRepository parkingRepository;
	@Override
	public ParkingEntity getParkingByName(String name) {
		return parkingRepository.findOne(name);
	}

	@Override
	public List<ParkingEntity> getAllParking() {
		return parkingRepository.findAll();
	}

	@Override
	public void insertParking(ParkingEntity parkingEntity) {
		parkingRepository.save(parkingEntity);
	}

}
