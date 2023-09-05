package com.springapp.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapp.vehicleservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmployeeEmail(String userEmail);

}
