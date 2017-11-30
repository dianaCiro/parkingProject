package unitTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.Vehicle;
import com.ceiba.service.VehicleService;

import testdatabuilder.VehicleTestDataBuilder;

public class VehicleUnitTest {
	
	private VehicleService vehicleService;
	private VehicleBuilder vehicleBuilder;
	
	@Test
	public void addVehicle() {
		
		//Arrange
		vehicleService = Mockito.mock(VehicleService.class);
		Vehicle vehicle= new VehicleTestDataBuilder().withNumberPlate("ASDF117").build();
		vehicleBuilder = new VehicleBuilder();
			
		//Act
		vehicleService.insertVehicle(vehicleBuilder.convertToEntity(vehicle));
		when(vehicleService.getVehicleByPlate(vehicle.getNumberPlate())).thenReturn(vehicleBuilder.convertToEntity(vehicle));
		
		//Assert
		assertNotNull(vehicleService.getVehicleByPlate(vehicle.getNumberPlate()));
	}
}
