package com.ceiba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entity.ParkingEntity;
import com.ceiba.service.ParkingService;

@RestController
public class ParkingController {

	@Autowired
	ParkingService parkingService;
	 
	@RequestMapping(value = "/parking", method = RequestMethod.GET)
	    public List<ParkingEntity> getAllParking() {
			return parkingService.getAllParking();
		}

	    @RequestMapping(value = "/parking/{name}", method = RequestMethod.GET)
	    public ParkingEntity getParking(@PathVariable("name") String name) {
			return parkingService.getParkingByName(name);
		}
}
