package integrationTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.ParkingApplication;
import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.Vehicle;
import com.ceiba.service.BusinessRulesService;
import com.ceiba.service.VehicleService;

import testdatabuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(
 classes = ParkingApplication.class)
public class BusinessRulesServiceIntegrationTest {
	
	private static final String AUTHORIZATION_MESSAGE = "Successfully registered vehicle";
	
	@Autowired
	@Qualifier("businesServiceQua")
	BusinessRulesService businesService;
	
	@Autowired
	VehicleService vehicleService;
	
	private VehicleBuilder vehicleBuilder;
	private String auxStr;

	@Test
	public void registerEntryVehicle() {
		
		//Arrange
		vehicleBuilder = new VehicleBuilder();
		Vehicle vehicle= new VehicleTestDataBuilder().withNumberPlate("ASDF117").build();
		
		//Act
		vehicleService.insertVehicle(vehicleBuilder.convertToEntity(vehicle));
		auxStr = businesService.registerEntryVehicle(vehicleBuilder.convertToEntity(vehicle));
		
		//Assert
		
		assertTrue(auxStr == AUTHORIZATION_MESSAGE);
	}
}
