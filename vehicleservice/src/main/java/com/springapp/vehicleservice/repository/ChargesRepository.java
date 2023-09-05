package com.springapp.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapp.vehicleservice.model.Charges;

public interface ChargesRepository extends JpaRepository<Charges, Integer> {

}
