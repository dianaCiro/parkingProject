package com.ceiba.domain;

import java.util.Calendar;

public class VehiclesInParking {

	private String numberPlate;
	private String type;
	private Calendar entryDate;
	
	public VehiclesInParking(String numberPlate, String type, Calendar entryDate) {
		super();
		this.numberPlate = numberPlate;
		this.type = type;
		this.entryDate = entryDate;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Calendar getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}
	
	
	
}
