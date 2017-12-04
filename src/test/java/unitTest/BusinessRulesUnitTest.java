package unitTest;

import org.junit.Before;
import org.junit.Test;
import com.ceiba.domain.Vehicle;
import com.ceiba.domain.BusinessRulesDomain;
import testdatabuilder.VehicleTestDataBuilder;
import java.util.Calendar;
import org.junit.Assert;

public class BusinessRulesUnitTest {
	

	private BusinessRulesDomain businessRules;
	private Calendar entryTime;
	private Calendar departureTime;
	private Vehicle vehicle;
	private int auxInt;
	private boolean auxBool;
	
	@Before
	public void setUp() {
		
		businessRules = new BusinessRulesDomain();
		entryTime = Calendar.getInstance();
		departureTime = Calendar.getInstance();
	}
	
	
	@Test
	public void initialLetterA(){
		
		//Arrange
		vehicle = new VehicleTestDataBuilder().withNumberPlate("aSD FFF").build();
		
		//Act
		auxBool = businessRules.isLetterInitialA(vehicle.getNumberPlate());
		
		//Assert
		Assert.assertTrue(auxBool);
	}
	
	/*Ingresa dia domingo con  placa inicial A */
	@Test
	public void allowEntry(){
		
		//Arrange
		vehicle = new VehicleTestDataBuilder().withNumberPlate("aSD FFF").build();
		entryTime.set(Calendar.DAY_OF_WEEK, 1);
		
		//Act
		auxBool = businessRules.allowEntry(vehicle, entryTime);
		
		//Assert
		Assert.assertTrue(auxBool);
	}
	
	@Test
	public void cylinderGreaterThan500(){
		
		//Arrange
		vehicle = new VehicleTestDataBuilder().withCylinder(510).build();
		//Act
		auxBool = businessRules.validateMotorcycleCylinder(vehicle);
		
		//Assert
		Assert.assertTrue(auxBool);
	}
	
	@Test
	public void calculateTimeSpent(){
		
		//Arrange
		entryTime.set(Calendar.HOUR_OF_DAY, 10);
		departureTime.set(Calendar.HOUR_OF_DAY, 22);
		
		//Act
		auxInt = businessRules.calculateTimeSpent(entryTime, departureTime);
		
		//Assert
		Assert.assertEquals(auxInt, 12);
		
	}
	
	@Test
	public void calculateTotalToPayMoto(){
		
		//Arrange
		entryTime.set(Calendar.HOUR_OF_DAY, 10);
		departureTime.set(Calendar.HOUR_OF_DAY, 20);
		vehicle = new VehicleTestDataBuilder().withCylinder(650).withVehicleType("motorcycle").build();
		
		//Act
		auxInt = businessRules.calculateTotalToPay(vehicle, entryTime, departureTime);
		
		//Assert
		Assert.assertEquals(auxInt, 6000);
		
		
	}
	
	@Test
	public void calculateTotalToPayCar(){
		
		//Arrange
		int entryDay = entryTime.get(Calendar.DAY_OF_MONTH);
		entryTime.set(Calendar.HOUR_OF_DAY, 1);
		departureTime.set(Calendar.DAY_OF_MONTH, entryDay + 1);
		departureTime.set(Calendar.HOUR_OF_DAY, 4);
		vehicle = new VehicleTestDataBuilder().withNumberPlate("ASD FFF").withVehicleType("car").build();
		
		//Act
		auxInt = businessRules.calculateTotalToPay(vehicle, entryTime, departureTime);
		
		//Assert
		Assert.assertEquals(auxInt, 11000);
		
		
	}
}


