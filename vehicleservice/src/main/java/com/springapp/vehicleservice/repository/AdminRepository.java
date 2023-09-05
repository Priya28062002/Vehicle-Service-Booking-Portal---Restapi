package com.springapp.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapp.vehicleservice.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByAdminEmail(String userEmail);

}
