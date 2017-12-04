package com.ceiba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.entity.VehicleEntity;
import com.ceiba.service.VehicleService;
import com.ceiba.util.RestResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VehicleController {

	@Autowired
	 VehicleService vehicleService;
	
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public List<VehicleEntity> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

    @RequestMapping(value = "/vehicle/{plate}", method = RequestMethod.GET)
    public VehicleEntity getVehicle(@PathVariable("plate") String plate) {
    	return vehicleService.getVehicleByPlate(plate);
	}
    
    @RequestMapping(value = "/createVehicle", method = RequestMethod.POST)
    public RestResponse saveVehicle(@RequestBody VehicleEntity vehicleEntity) {
    	if(!validate(vehicleEntity)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), 
							"The obligatory fields are not filled out");
		}
    	vehicleService.insertVehicle(vehicleEntity);
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
