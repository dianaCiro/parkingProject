package unitTest;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.builder.ReceipBuilder;
import com.ceiba.domain.Receip;
import com.ceiba.domain.Vehicle;
import com.ceiba.service.ReceipService;
import testdatabuilder.VehicleTestDataBuilder;


public class ReceipUnitTest {
	
	private ReceipService receipService;
	private ReceipBuilder receipBuilder;
	private Vehicle vehicle;
	private Calendar entryTime;
	private Receip receip;
	
	@Before
	public void setUp() {
		receipService = Mockito.mock(ReceipService.class);
		receipBuilder = new ReceipBuilder();
		vehicle = new VehicleTestDataBuilder().build();
		entryTime = Calendar.getInstance();
		receip= new Receip();
		receip.setVehicle(vehicle);
		receip.setEntryTime(entryTime);
	}
	/*
	@Test
	public void addReceip() {
		
		//Arrange
		when(receipService.getReceipByVehicleId(vehicle.getNumberPlate())).thenReturn(receipBuilder.convertToEntity(receip));
		//Act
		receipService.insertReceip(receipBuilder.convertToEntity(receip));
		//Assert
		assertNotNull(receipService.getReceipByVehicleId(vehicle.getNumberPlate()));
	}
	*/
	
	@Test
	public void getReceipWithoutCancel() {
		//Arrange
		when(receipService.getReceipWithoutCancel(vehicle.getNumberPlate())).thenReturn(receipBuilder.convertToEntity(receip));
		//Act
		receipService.insertReceip(receipBuilder.convertToEntity(receip));
		//Assert
		Calendar c = receipService.getReceipWithoutCancel(vehicle.getNumberPlate()).getDepartureTime();
		System.out.println(c);
		assertNull(receipService.getReceipWithoutCancel(vehicle.getNumberPlate()).getDepartureTime());
		assertTrue(receipService.getReceipWithoutCancel(vehicle.getNumberPlate()).getPayment() == 0);
	}
}
