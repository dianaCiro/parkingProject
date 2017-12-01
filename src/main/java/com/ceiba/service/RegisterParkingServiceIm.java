package com.ceiba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entity.RegisterParkingEntity;
import com.ceiba.repository.RegisterParkingRepository;

@Service("registerParkingService")
public class RegisterParkingServiceIm implements RegisterParkingService{

	@Autowired
	RegisterParkingRepository receipRepository;

	@Override
	public List<RegisterParkingEntity> getAll() {
		return receipRepository.findAll();
	}

	@Override
	public void insert(RegisterParkingEntity registerParkingEntity) {
		 receipRepository.save(registerParkingEntity);
		
	}

	@Override
	public RegisterParkingEntity getRegisterWithoutCancel(String numberPlate) {
		return receipRepository.findReceipWithoutCancel(numberPlate);
	}

	

}
