package com.springapp.vehicleservice.service;

import org.springframework.http.ResponseEntity;

import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.model.Employee;

public interface EmployeeService {
    
    public ResponseEntity<?> loginEmployee(LoginDTO loginDTO);

    public ResponseEntity<?> registerEmployee(Employee employee);

    public ResponseEntity<Boolean> isEmployee(String emailId);

}
