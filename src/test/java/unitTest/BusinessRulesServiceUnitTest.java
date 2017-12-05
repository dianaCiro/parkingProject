package unitTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.Vehicle;
import com.ceiba.service.BusinessRulesService;
import com.ceiba.service.VehicleService;

import testdatabuilder.VehicleTestDataBuilder;

public class BusinessRulesServiceUnitTest {
	
	private static final String AUTHORIZATION_MESSAGE = "Successfully registered vehicle";
	private BusinessRulesService businesService;
	private VehicleService vehicleService;
	private VehicleBuilder vehicleBuilder;
	private String auxStr;
	
	@Before
	public void setUp() {
		vehicleBuilder = new VehicleBuilder();
		businesService = Mockito.mock(BusinessRulesService.class);
		vehicleService = Mockito.mock(VehicleService.class);
	}
	
	/*
	@Test
	public void registerEntryVehicle() {
		
		//Arrange
		Vehicle vehicle = new VehicleTestDataBuilder().withNumberPlate("GGB123").build();
		when(businesService.registerEntryVehicle(vehicleBuilder.convertToEntity(vehicle))).thenReturn(AUTHORIZATION_MESSAGE);
		
		//Act
		vehicleService.insertVehicle(vehicleBuilder.convertToEntity(vehicle));
		auxStr = businesService.registerEntryVehicle(vehicleBuilder.convertToEntity(vehicle));
		
		//Assert
	
		assertNotNull(auxStr);
	}*/
}
