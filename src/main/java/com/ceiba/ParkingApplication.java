package com.ceiba;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ceiba.builder.ParkingBuilder;
import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.BusinessRules;
import com.ceiba.domain.Parking;
import com.ceiba.domain.Vehicle;
import com.ceiba.repository.ParkingRepository;
import com.ceiba.repository.VehicleRepository;
import com.ceiba.service.BusinessRulesService;
import com.ceiba.service.BusinessRulesServiceIm;



@SpringBootApplication
public class ParkingApplication {

	private static final Logger logger = LoggerFactory.getLogger(ParkingApplication.class);
	private static ParkingBuilder parkingBuilder = new ParkingBuilder();
	private static VehicleBuilder vehicleBuilder = new VehicleBuilder();
	
	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner setup(ParkingRepository parkingRepository) {
		return (args) -> {
			parkingRepository.save(parkingBuilder.convertToEntity(new Parking("Puerto Seco", 20, 10, 1000, 500, 8000, 4000)));
			parkingRepository.save(parkingBuilder.convertToEntity(new Parking("Terminal del sur", 20, 10, 1000, 500, 8000, 4000)));
			logger.info("The sample data has been generated");
		};
	}
	
	@Bean
	public CommandLineRunner setupp(VehicleRepository vehicleRepository) {
		return (args) -> {
			vehicleRepository.save(vehicleBuilder.convertToEntity(new Vehicle("ASD117",600,"HONDA","moto")));
			vehicleRepository.save(vehicleBuilder.convertToEntity(new Vehicle("ASD11777",600,"HONDA","carro")));
			logger.info("The sample data has been generated");
		};
	}


	@Bean
	@Qualifier("businesServiceQua")
	public BusinessRulesService businessRulesService() {
		return new BusinessRulesServiceIm();
	}
	
	@Bean
	@Qualifier("businessRulesQua")
	public BusinessRules businessRules() {
		return new BusinessRules();
	}
	
	@Bean 
	@Qualifier("vehicleBuilder")
	public VehicleBuilder vehicleBuilder() {
		return new VehicleBuilder();
	}
}
