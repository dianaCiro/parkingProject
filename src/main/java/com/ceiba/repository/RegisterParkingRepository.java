package com.ceiba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.RegisterParkingEntity;

@Repository("receipRepository")
public interface RegisterParkingRepository extends JpaRepository<RegisterParkingEntity, Integer> {


	
	  @Query("SELECT registerParking FROM RegisterParking registerParking WHERE registerParking.vehicle.numberPlate = :idVehicle and "
	  		+ "registerParking.departureTime IS NULL and registerParking.payment = 0 ")
	  RegisterParkingEntity findReceipWithoutCancel(@Param("idVehicle") String idVehicle);
	  
}

