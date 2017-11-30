package testdatabuilder;

import com.ceiba.domain.Parking;

public class ParkingTestDataBuilder {
	
	private static final String NAME = "Diana";
	private static final int CAR_CAPACITY = 20;
	private static final int MOTORCYCLE_CAPACITY = 10;
	private static final int CAR_HOUR_VALUE = 1000;
	private static final int MOTORCYCLE_HOUR_VALUE = 500;
	private static final int CAR_DAY_VALUE = 8000;
	private static final int MOTORCYCLE_DAY_VALUE = 4000;
	
	private String name;
	private int carCapacity;
	private int motorcycleCapacity;
	private int carHourValue;
	private int motorcycleHourValue;
	private int carDayValue;
	private int motorcycleDayValue;
	
	public ParkingTestDataBuilder(){
		this.name = NAME;
		this.carCapacity = CAR_CAPACITY;
		this.motorcycleCapacity = MOTORCYCLE_CAPACITY;
		this.carHourValue = CAR_HOUR_VALUE;
		this.motorcycleHourValue = MOTORCYCLE_HOUR_VALUE;
		this.carDayValue = CAR_DAY_VALUE;
		this.motorcycleDayValue = MOTORCYCLE_DAY_VALUE;
	}
	
	public ParkingTestDataBuilder withName(String name){
		this.name = name;
		return this;
	}
	
	public ParkingTestDataBuilder withCarCapacity(int carCapacity){
		this.carCapacity = carCapacity;
		return this;
	}
	
	public ParkingTestDataBuilder withMotorcycleCapacity(int motorcycleCapacity){
		this.motorcycleCapacity = motorcycleCapacity;
		return this;
	}
	
	public ParkingTestDataBuilder withCarHourValue(int carHourValue){
		this.carHourValue = carHourValue;
		return this;
	}
	
	public ParkingTestDataBuilder withMotorcycleHourValue(int motorcycleHourValue){
		this.motorcycleHourValue = motorcycleHourValue;
		return this;
	}
	
	public ParkingTestDataBuilder withCarDayValue(int carDayValue){
		this.carDayValue = carDayValue;
		return this;
	}
	
	public ParkingTestDataBuilder withMotorcycleDayValue(int motorcycleDayValue){
		this.motorcycleDayValue = motorcycleDayValue;
		return this;
	}
	
	public Parking build(){
		return new Parking(name, carCapacity, motorcycleCapacity, carHourValue, 
				           motorcycleHourValue, carDayValue, motorcycleDayValue);
	}
}
