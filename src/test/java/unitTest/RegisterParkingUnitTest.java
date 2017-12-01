package unitTest;




import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.builder.RegisterParkingBuilder;
import com.ceiba.domain.RegisterParking;
import com.ceiba.domain.Vehicle;
import com.ceiba.service.RegisterParkingService;
import testdatabuilder.VehicleTestDataBuilder;


public class RegisterParkingUnitTest {
	
	private RegisterParkingService registerService;
	private RegisterParkingBuilder registerBuilder;
	private Vehicle vehicle;
	private Calendar entryTime;
	private RegisterParking registerParking;
	
	@Before
	public void setUp() {
		registerService = Mockito.mock(RegisterParkingService.class);
		registerBuilder = new RegisterParkingBuilder();
		vehicle = new VehicleTestDataBuilder().build();
		entryTime = Calendar.getInstance();
		registerParking= new RegisterParking();
		registerParking.setVehicle(vehicle);
		registerParking.setEntryTime(entryTime);
	}
	
	
	@Test
	public void getReceipWithoutCancel() {
		//Arrange
		when(registerService.getRegisterWithoutCancel(vehicle.getNumberPlate())).thenReturn(registerBuilder.convertToEntity(registerParking));
		//Act
		registerService.insert(registerBuilder.convertToEntity(registerParking));
		//Assert
		assertNull(registerService.getRegisterWithoutCancel(vehicle.getNumberPlate()).getDepartureTime());
		assertTrue(registerService.getRegisterWithoutCancel(vehicle.getNumberPlate()).getPayment() == 0);
	}
}
