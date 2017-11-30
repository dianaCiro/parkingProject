package integrationTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ceiba.ParkingApplication;
import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.Vehicle;
import com.ceiba.service.VehicleService;
import testdatabuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(
 classes = ParkingApplication.class)
public class VehicleIntegrationTest {

	@Autowired
	VehicleService vehicleService;
	
	private VehicleBuilder vehicleBuilder;
	@Test
	public void addVehicle() {
		
		//Arrange
		Vehicle vehicle= new VehicleTestDataBuilder().withNumberPlate("ASDF117").build();
		vehicleBuilder = new VehicleBuilder();
			
		//Act
		vehicleService.insertVehicle(vehicleBuilder.convertToEntity(vehicle));
		
		//Assert
		assertNotNull(vehicleService.getVehicleByPlate(vehicle.getNumberPlate()));
	}
}
