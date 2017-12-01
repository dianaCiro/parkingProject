package com.ceiba.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "RegisterParking")
public class RegisterParkingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_vehicle",referencedColumnName="numberPlate")
	private VehicleEntity vehicle;
	
	@Column(nullable = false)
	private Calendar entryTime;
	@Column
	private Calendar departureTime;
	@Column
	private double payment;
	
	public VehicleEntity getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleEntity vehicle) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
