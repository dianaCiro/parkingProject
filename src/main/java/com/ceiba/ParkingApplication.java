package com.ceiba;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ceiba.builder.VehicleBuilder;
import com.ceiba.domain.BusinessRulesDomain;
import com.ceiba.domain.Vehicle;
import com.ceiba.repository.VehicleRepository;
import com.ceiba.service.BusinessRulesService;
import com.ceiba.service.BusinessRulesServiceIm;



@SpringBootApplication
public class ParkingApplication {

	private static final Logger logger = LoggerFactory.getLogger(ParkingApplication.class);
	private static VehicleBuilder vehicleBuilder = new VehicleBuilder();
	
	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
		
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
	public BusinessRulesDomain businessRules() {
		return new BusinessRulesDomain();
	}
	
	@Bean 
	@Qualifier("vehicleBuilder")
	public VehicleBuilder vehicleBuilder() {
		return new VehicleBuilder();
	}
}
