package com.ceiba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.ReceipEntity;

@Repository("receipRepository")
public interface ReceipRepository extends JpaRepository<ReceipEntity, Integer> {


	
	  @Query("SELECT receip FROM Receip receip WHERE receip.vehicle.numberPlate = :idVehicle and "
	  		+ "receip.departureTime IS NULL and receip.payment = 0 ")
	  ReceipEntity findReceipWithoutCancel(@Param("idVehicle") String idVehicle);
	  
}

