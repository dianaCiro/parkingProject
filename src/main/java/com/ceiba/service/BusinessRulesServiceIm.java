package com.ceiba.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ceiba.domain.Vehicle;
import com.ceiba.domain.VehiclesInParking;
import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.BusinessRulesDomain;
import com.ceiba.entity.RegisterParkingEntity;
import com.ceiba.entity.VehicleEntity;

@Service("businessRulesService")
public class BusinessRulesServiceIm implements BusinessRulesService{

	@Autowired
	private RegisterParkingService registerParkingService;
	
	@Autowired
	@Qualifier("businessRulesQua")
	BusinessRulesDomain businessRules;
	
	@Autowired
	@Qualifier("vehicleBuilder")
	VehicleBuilder vehicleBuilder;
	
	private static final String CAR = "car";
	private static final String MOTORCYCLE = "motorcycle";
	private static final String AUTHORIZATION_MESSAGE = "Successfully registered vehicle";
	private static final String DENIED_ENTRY = "Denied entry";
	private static final String CAPACITY_PARKING = "There is no space available for this vehicle, the parking lot is completely full";
	private static final String VEHICLE_IN_PARKING = "There is not register of exit of this vehicle";
	private static final int CAR_CAPACITY = 20;
	private static final int MOTORCYCLE_CAPACITY = 10;

	public BusinessRulesServiceIm() {}

	@Override
	public int getTotalCarInParking() {
		int totalCar = 0;
		List<RegisterParkingEntity> listRegisters = getAllRegister();
		
		for(RegisterParkingEntity register : listRegisters) {
			if(register.getVehicle().getVehicleType().equals(CAR)) {
				totalCar += 1;
			}
		}
		return totalCar;
	}

	@Override
	public int getTotalMotorcycleInParking() {
		
		int totalMotorcycle = 0;
		List<RegisterParkingEntity> listRegisters = getAllRegister();
		
		for(RegisterParkingEntity register : listRegisters) {
			if(register.getVehicle().getVehicleType().equals(MOTORCYCLE)) {
				totalMotorcycle += 1;
			}
		}
		return totalMotorcycle;
	}

	@Override
	public String registerEntryVehicle(VehicleEntity vehicleEntity) {
		
		String numberPlate = vehicleEntity.getNumberPlate();
		Calendar entryDate = Calendar.getInstance();
		
		entryDate.set(Calendar.DAY_OF_WEEK,1);
		//entryDate.set(Calendar.HOUR_OF_DAY, 10);
		RegisterParkingEntity registerParkingE;
		String vehicleType = vehicleEntity.getVehicleType();
		
		if(!businessRules.allowEntry(vehicleBuilder.convertToDomain(vehicleEntity), entryDate)) {
			return DENIED_ENTRY;
		}else if(vehicleType.equalsIgnoreCase(CAR)){
			if(getTotalCarInParking() >= CAR_CAPACITY) {
				return CAPACITY_PARKING;
			}
		}else if(vehicleType.equalsIgnoreCase(MOTORCYCLE)) {
			if(getTotalMotorcycleInParking() >= MOTORCYCLE_CAPACITY) {
				return CAPACITY_PARKING;
			}
		}
		if(registerParkingService.getRegisterWithoutCancel(numberPlate)!= null) {
			return VEHICLE_IN_PARKING;
		}
		
		registerParkingE = new RegisterParkingEntity();
		registerParkingE.setVehicle(vehicleEntity);
		registerParkingE.setEntryTime(entryDate);
		
		registerParkingService.insert(registerParkingE);
		
		return AUTHORIZATION_MESSAGE;
	}

	@Override
	public void registerDepartureVehicle(VehicleEntity vehicleEntity) {
		
		
		
		double totalToPay;
		Calendar entryTime;
		RegisterParkingEntity registerEntity;
		Calendar departureDate = Calendar.getInstance();
		//departureDate.set(Calendar.DAY_OF_WEEK,3);
		//departureDate.set(Calendar.HOUR_OF_DAY, 20);
		Vehicle vehicle = vehicleBuilder.convertToDomain(vehicleEntity);
		
		registerEntity = registerParkingService.getRegisterWithoutCancel(vehicleEntity.getNumberPlate());
		entryTime = registerEntity.getEntryTime();
		totalToPay = businessRules.calculateTotalToPay(vehicle, entryTime, departureDate);
		registerEntity.setDepartureTime(departureDate);
		registerEntity.setPayment(totalToPay);
		
		registerParkingService.insert(registerEntity);
	}

	@Override
	public List<VehiclesInParking> getAllVehicles() {
		
		VehicleEntity vehicle;
		VehiclesInParking vehicleParking;
		List<VehiclesInParking> vehicles = new ArrayList<>();
		List<RegisterParkingEntity> registers = registerParkingService.getAll();
		
		for(RegisterParkingEntity register : registers) {
			vehicle = register.getVehicle();
			vehicleParking = new VehiclesInParking(vehicle.getNumberPlate(), vehicle.getVehicleType(), register.getEntryTime());
			vehicles.add(vehicleParking);
		}
		return vehicles; 
	}
	
	public List<RegisterParkingEntity> getAllRegister(){
		return registerParkingService.getAll();
	}

}
