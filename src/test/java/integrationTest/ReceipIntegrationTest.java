package integrationTest;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ceiba.ParkingApplication;
import com.ceiba.builder.ReceipBuilder;
import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.Receip;
import com.ceiba.domain.Vehicle;
import com.ceiba.service.ReceipService;
import com.ceiba.service.VehicleService;

import testdatabuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(
 classes = ParkingApplication.class)
public class ReceipIntegrationTest {

	@Autowired
	private ReceipService receipService;
	
	@Autowired
	private VehicleService vehicleService;
	
	private ReceipBuilder receipBuilder;
	private VehicleBuilder vehicleBuilder;
	private Vehicle vehicle;
	private Calendar entryTime;
	private Receip receip;
	
	@Before
	public void setUp() {
		receipBuilder = new ReceipBuilder();
		vehicleBuilder = new VehicleBuilder();
		vehicle = new VehicleTestDataBuilder().build();
		entryTime = Calendar.getInstance();
		receip= new Receip();
		receip.setVehicle(vehicle);
		receip.setEntryTime(entryTime);
	}
	
	
	
	@Test
	public void getReceipWithoutCancel() {
		
		//Act
		vehicleService.insertVehicle(vehicleBuilder.convertToEntity(vehicle));
		receipService.insertReceip(receipBuilder.convertToEntity(receip));
		//Assert
		assertNull(receipService.getReceipWithoutCancel(vehicle.getNumberPlate()).getDepartureTime());
		assertTrue(receipService.getReceipWithoutCancel(vehicle.getNumberPlate()).getPayment() == 0);
	}
}
