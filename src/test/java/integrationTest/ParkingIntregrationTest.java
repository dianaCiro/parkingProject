package integrationTest;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.ParkingApplication;
import com.ceiba.builder.ParkingBuilder;
import com.ceiba.domain.Parking;
import com.ceiba.service.ParkingService;

import testdatabuilder.ParkingTestDataBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest(
 classes = ParkingApplication.class)
public class ParkingIntregrationTest {
	
	@Autowired
	ParkingService parkingService;
	
	
	private ParkingBuilder parkingBuilder;
	
	@Test
	public void addParking() {
		
		//Arrange
		Parking parking = new ParkingTestDataBuilder().withName("prueba").build();
		parkingBuilder = new ParkingBuilder();
		//Act
		
		parkingService.insertParking(parkingBuilder.convertToEntity(parking));
		//Assert
		
		assertNotNull(parkingService.getParkingByName(parking.getName()));
	}
}
