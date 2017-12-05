package com.ceiba.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.domain.VehiclesInParking;
import com.ceiba.entity.VehicleEntity;
import com.ceiba.service.BusinessRulesService;
import com.ceiba.util.RestResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BusinessRulesController {

	private static final String DENIED_ENTRY = "Denied entry";
	private static final String VEHICLE_IN_PARKING = "There is not register of exit of this vehicle";
	private static final String VEHICLE_NOT_REGISTERED = "The vehicle is not in the parking ";
	
	@Autowired
	@Qualifier("businesServiceQua")
	BusinessRulesService businessService;

	
	@RequestMapping(value = "/registers", method = RequestMethod.GET)
	public List<VehiclesInParking> getAllRegisters() {
		return businessService.getAllVehicles();
	}

	
	@RequestMapping(value = "/createRegister", method = RequestMethod.POST)
	public RestResponse saveVehicle(@RequestBody VehicleEntity vehicleEntity) {
		String message;
		
		if(!validate(vehicleEntity)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), 
							"The obligatory fields are not filled out");
		}
		message = businessService.registerEntryVehicle(vehicleEntity);
		if(message.equalsIgnoreCase(DENIED_ENTRY)) {
			return new RestResponse(301, message);
		}else if (message.equalsIgnoreCase(VEHICLE_IN_PARKING)){
				return new RestResponse(303, message);
			}
		
		return new RestResponse(HttpStatus.OK.value(), "Successfull operation");
	}

	
	@RequestMapping(value = "/updateRegister", method = RequestMethod.POST)
	public RestResponse updateVehicle(@RequestBody VehicleEntity vehicleEntity) {
		String message;
		
		if(!validate(vehicleEntity)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), 
							"The obligatory fields are not filled out");
		}
		
		message = businessService.registerDepartureVehicle(vehicleEntity);
		if(message.equalsIgnoreCase(VEHICLE_NOT_REGISTERED)) {
			return new RestResponse(304, message);
		}
		return new RestResponse(HttpStatus.OK.value(), "Successfull operation");
	}
	
	private boolean validate (VehicleEntity vehicleEntity) {
		boolean isValid = true;
		if(vehicleEntity.getBrand()==null) {isValid = false;}
		if(vehicleEntity.getCylinder()== 0) {isValid = false;}
		if(vehicleEntity.getNumberPlate()==null) {isValid = false;}
		if(vehicleEntity.getVehicleType()==null) {isValid = false;}
		return isValid;
	}
}
