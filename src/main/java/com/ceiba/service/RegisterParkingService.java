package com.ceiba.service;

import java.util.List;

import com.ceiba.entity.RegisterParkingEntity;
public interface RegisterParkingService {


	RegisterParkingEntity getRegisterWithoutCancel(String numberPlate);
	List<RegisterParkingEntity> getAll();
	void insert(RegisterParkingEntity registerParkingEntity);
}
