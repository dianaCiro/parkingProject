package com.ceiba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entity.ReceipEntity;
import com.ceiba.repository.ReceipRepository;

@Service("receipServiceIm")
public class ReceipServiceIm implements ReceipService{

	@Autowired
	ReceipRepository receipRepository;

	@Override
	public List<ReceipEntity> getAllReceips() {
		return receipRepository.findAll();
	}

	@Override
	public void insertReceip(ReceipEntity receipEntity) {
		 receipRepository.save(receipEntity);
		
	}

	@Override
	public ReceipEntity getReceipWithoutCancel(String numberPlate) {
		return receipRepository.findReceipWithoutCancel(numberPlate);
	}

	

}
