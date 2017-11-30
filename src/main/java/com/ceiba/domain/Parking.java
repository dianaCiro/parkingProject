package com.ceiba.domain;



public class Parking {
	
	private String name;
	private int carCapacity;
	private int motorcycleCapacity;
	private int carHourValue;
	private int motorcycleHourValue;
	private int carDayValue;
	private int motorcycleDayValue;
	
	

	public Parking(String name, int carCapacity, int motorcycleCapacity, int carHourValue, int motorcycleHourValue,
			int carDayValue, int motorcycleDayValue) {
		this.name = name;
		this.carCapacity = carCapacity;
		this.motorcycleCapacity = motorcycleCapacity;
		this.carHourValue = carHourValue;
		this.motorcycleHourValue = motorcycleHourValue;
		this.carDayValue = carDayValue;
		this.motorcycleDayValue = motorcycleDayValue;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCarCapacity() {
		return carCapacity;
	}



	public void setCarCapacity(int carCapacity) {
		this.carCapacity = carCapacity;
	}



	public int getMotorcycleCapacity() {
		return motorcycleCapacity;
	}



	public void setMotorcycleCapacity(int motorcycleCapacity) {
		this.motorcycleCapacity = motorcycleCapacity;
	}



	public int getCarHourValue() {
		return carHourValue;
	}



	public void setCarHourValue(int carHourValue) {
		this.carHourValue = carHourValue;
	}



	public int getMotorcycleHourValue() {
		return motorcycleHourValue;
	}



	public void setMotorcycleHourValue(int motorcycleHourValue) {
		this.motorcycleHourValue = motorcycleHourValue;
	}



	public int getCarDayValue() {
		return carDayValue;
	}



	public void setCarDayValue(int carDayValue) {
		this.carDayValue = carDayValue;
	}



	public int getMotorcycleDayValue() {
		return motorcycleDayValue;
	}



	public void setMotorcycleDayValue(int motorcycleDayValue) {
		this.motorcycleDayValue = motorcycleDayValue;
	}

	
	
	
		
}
