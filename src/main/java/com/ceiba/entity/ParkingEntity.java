package com.ceiba.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class ParkingEntity {
	
	@Id
	private String name;
	@Column(nullable = false)
	private int carCapacity;
	@Column(nullable = false)
	private int motorcycleCapacity;
	@Column(nullable = false)
	private int carHourValue;
	@Column(nullable = false)
	private int motorcycleHourValue;
	@Column(nullable = false)
	private int carDayValue;
	@Column(nullable = false)
	private int motorcycleDayValue;
	
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
