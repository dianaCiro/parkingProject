package com.ceiba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entity.RegisterParkingEntity;
import com.ceiba.service.RegisterParkingService;

@RestController
public class RegisterParkingController {
	
	@Autowired
	RegisterParkingService registerService;
	 
	@RequestMapping(value = "/detailsRegisters", method = RequestMethod.GET)
	    public List<RegisterParkingEntity> getAllParking() {
			return registerService.getAll();
		}

	    
	    
}
