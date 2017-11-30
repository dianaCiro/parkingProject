package com.ceiba.domain;

public class Vehicle {
	
	private String numberPlate;
	private int cylinder;
	private String brand;
	private String vehicleType;
	
	public Vehicle(String numberPlate, int cylinder, String brand, String vehicleType) {
		this.numberPlate = numberPlate;
		this.cylinder = cylinder;
		this.brand = brand;
		this.vehicleType = vehicleType;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getCylinder() {
		return cylinder;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
	
}
