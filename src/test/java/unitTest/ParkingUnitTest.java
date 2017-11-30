package unitTest;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.ceiba.builder.ParkingBuilder;
import com.ceiba.domain.Parking;
import com.ceiba.service.ParkingService;

import testdatabuilder.ParkingTestDataBuilder;

public class ParkingUnitTest {
	
	
	private ParkingService parkingService;
	private ParkingBuilder parkingBuilder;
	
	
	
	@Test
	public void addParking() {
		
		//Arrange
		parkingService = Mockito.mock(ParkingService.class);
		Parking parking= new ParkingTestDataBuilder().withName("Prueba").build();
		parkingBuilder = new ParkingBuilder();
		
		//Act
		parkingService.insertParking(parkingBuilder.convertToEntity(parking));
		when(parkingService.getParkingByName(parking.getName())).thenReturn(parkingBuilder.convertToEntity(parking));
		//Assert
		
		assertNotNull(parkingService.getParkingByName(parking.getName()));
	}
}
