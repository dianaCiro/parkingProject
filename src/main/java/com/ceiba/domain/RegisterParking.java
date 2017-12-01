package com.ceiba.domain;

import java.util.Calendar;

public class RegisterParking {
	
	private Vehicle vehicle;
	private Calendar entryTime;
	private Calendar departureTime;
	private double payment;
	
	public RegisterParking(Vehicle vehicle, Calendar entryTime, Calendar departureTime, double payment) {
		this.vehicle = vehicle;
		this.entryTime = entryTime;
		this.departureTime = departureTime;
		this.payment = payment;
	}
	public RegisterParking() {}
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Calendar getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Calendar entryTime) {
		this.entryTime = entryTime;
	}

	public Calendar getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Calendar departureTime) {
		this.departureTime = departureTime;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	
}
