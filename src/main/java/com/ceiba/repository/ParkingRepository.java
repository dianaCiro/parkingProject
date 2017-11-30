package com.ceiba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.ParkingEntity;

@Repository("parkingRepository")
public interface ParkingRepository extends JpaRepository<ParkingEntity, String>{

}
