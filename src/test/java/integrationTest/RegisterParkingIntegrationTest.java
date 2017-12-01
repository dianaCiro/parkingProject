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
import com.ceiba.builder.RegisterParkingBuilder;
import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.RegisterParking;
import com.ceiba.domain.Vehicle;
import com.ceiba.service.RegisterParkingService;
import com.ceiba.service.VehicleService;

import testdatabuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(
 classes = ParkingApplication.class)
public class RegisterParkingIntegrationTest {

	@Autowired
	private RegisterParkingService registerService;
	
	@Autowired
	private VehicleService vehicleService;
	
	private RegisterParkingBuilder registerBuilder;
	private VehicleBuilder vehicleBuilder;
	private Vehicle vehicle;
	private Calendar entryTime;
	private RegisterParking registerParking;
	
	@Before
	public void setUp() {
		registerBuilder = new RegisterParkingBuilder();
		vehicleBuilder = new VehicleBuilder();
		vehicle = new VehicleTestDataBuilder().build();
		entryTime = Calendar.getInstance();
		registerParking= new RegisterParking();
		registerParking.setVehicle(vehicle);
		registerParking.setEntryTime(entryTime);
	}
	
	
	
	@Test
	public void getReceipWithoutCancel() {
		
		//Act
		vehicleService.insertVehicle(vehicleBuilder.convertToEntity(vehicle));
		registerService.insert(registerBuilder.convertToEntity(registerParking));
		//Assert
		assertNull(registerService.getRegisterWithoutCancel(vehicle.getNumberPlate()).getDepartureTime());
		assertTrue(registerService.getRegisterWithoutCancel(vehicle.getNumberPlate()).getPayment() == 0);
	}
	
	
}
