package com.ceiba.domain;

import java.util.Calendar;


public class BusinessRules {

	private static final int CAR_HOUR_VALUE = 1000;
	private static final int MOTORCYCLE_HOUR_VALUE = 500;
	private static final int CAR_DAY_VALUE = 8000;
	private static final int MOTORCYCLE_DAY_VALUE = 4000;
	private static final int SURPLUS_MOTORCYCLE = 2000;
	private static final int START_TIME_DAY = 9;
	private static final String MOTORCYCLE = "motorcycle";
	

	public BusinessRules() {}

	public boolean isLetterInitialA(String plate) {
		char letter = plate.toLowerCase().charAt(0);
		return letter == 'a';
	}

	public boolean validateMotorcycleCylinder(Vehicle vehicle) {
		return (vehicle.getCylinder() > 500);
	}

	public boolean allowEntry(Vehicle vehicle, Calendar date) {

		int day;
		day = date.get(Calendar.DAY_OF_WEEK);

		if (isLetterInitialA(vehicle.getNumberPlate())) {
			if (day == 1 || day == 2) {
				return false;
			}
		}
		return true;
	}

	public int calculateTimeSpent(Calendar entryTime, Calendar departureTime) {

		int hourEntry;
		int hourDeparture;
		int totalTime;
		int dayEntry;
		int dayDeparture;
		int totalDays;
		int maxDayOfMonth;
		
		dayEntry = entryTime.get(Calendar.DAY_OF_MONTH);
		dayDeparture = departureTime.get(Calendar.DAY_OF_MONTH);
		
		if(departureTime.get(Calendar.MONTH) > entryTime.get(Calendar.MONTH)) {
			maxDayOfMonth = entryTime.getActualMaximum(Calendar.DAY_OF_MONTH);
			dayDeparture = dayDeparture + maxDayOfMonth;
		}
		totalDays = dayDeparture - dayEntry;
		
		
		hourEntry = entryTime.get(Calendar.HOUR_OF_DAY);
		hourDeparture = departureTime.get(Calendar.HOUR_OF_DAY);
		totalTime = (totalDays * 24) + hourDeparture - hourEntry;

		return totalTime;
	}

	public int calculateTotalToPay(Vehicle vehicle, Calendar entryTime, Calendar departureTime) {

		int totalHours;
		int hours = 0;
		int days = 0;
		int totalToPay = 0;

		totalHours = calculateTimeSpent(entryTime, departureTime);

		if (totalHours >= 24) {
			hours = totalHours % 24;
			days = totalHours / 24;
		} else if (totalHours > START_TIME_DAY && totalHours <= 24) {
			days = 1;
		} else {
			hours = totalHours;
		}

		if (vehicle.getVehicleType().equalsIgnoreCase(MOTORCYCLE)) {
			hours = hours * MOTORCYCLE_HOUR_VALUE;
			days = days * MOTORCYCLE_DAY_VALUE;
			if (validateMotorcycleCylinder(vehicle)) {
				totalToPay = hours + days + SURPLUS_MOTORCYCLE;
			} else {
				totalToPay = hours + days;
			}
		} else {
			hours = hours * CAR_HOUR_VALUE;
			days = days * CAR_DAY_VALUE;
			totalToPay = hours + days;
		}

		return totalToPay;
	}
	
	
}
