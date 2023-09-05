package com.springapp.vehicleservice.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springapp.vehicleservice.model.VehicleService;

public interface VehicleServiceRepository extends JpaRepository<VehicleService, Integer> {

    Optional<VehicleService> findByVehicleId(int id);

    @Query("SELECT vs FROM VehicleService vs WHERE vs.status = 'open'")
	Page<VehicleService> findAllOpenServices(Pageable pageable);
    
}
