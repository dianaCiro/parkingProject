package com.ceiba.service;

import java.util.List;

import com.ceiba.entity.ReceipEntity;
public interface ReceipService {


	ReceipEntity getReceipWithoutCancel(String numberPlate);
	List<ReceipEntity> getAllReceips();
	void insertReceip(ReceipEntity receipEntity);
}
