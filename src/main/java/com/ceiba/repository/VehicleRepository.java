package com.ceiba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.VehicleEntity;

@Repository("vehicleRepository")
public interface VehicleRepository extends JpaRepository<VehicleEntity, String>{

}
