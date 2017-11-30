package com.ceiba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entity.VehicleEntity;
import com.ceiba.repository.VehicleRepository;

@Service("vehicleService")
public class VehicleServiceIm implements VehicleService{

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public VehicleEntity getVehicleByPlate(String numberPlate) {
		return vehicleRepository.findOne(numberPlate);
	}

	@Override
	public List<VehicleEntity> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	@Override
	public void insertVehicle(VehicleEntity vehicleEntity) {
		vehicleRepository.save(vehicleEntity);
		
	}

}
