package testdatabuilder;

import com.ceiba.domain.Vehicle;

public class VehicleTestDataBuilder {
	
	private static final String NUMBER_PLATE = "AS1156";
	private static final int CYLINDER = 500;
	private static final String BRAND = "HUNDAI";
	private static final String VEHICLE_TYPE = "Carro";
	
	private String numberPlate;
	private int cylinder;
	private String brand;
	private String vehicleType;
	
	public VehicleTestDataBuilder() {
		this.numberPlate = NUMBER_PLATE;
		this.cylinder = CYLINDER;
		this.brand = BRAND;
		this.vehicleType = VEHICLE_TYPE;
	}
	
	public VehicleTestDataBuilder withNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
		return this;
	}
	
	public VehicleTestDataBuilder withCylinder(int cilynder) {
		this.cylinder = cilynder;
		return this;
	}
	
	public VehicleTestDataBuilder withBrand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public VehicleTestDataBuilder withVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}
	
	public Vehicle build() {
		return new Vehicle(numberPlate, cylinder, brand, vehicleType);
	}
}
