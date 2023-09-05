package com.springapp.vehicleservice.service;

import org.springframework.http.ResponseEntity;

import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.model.Admin;

public interface AdminService {
    
    public ResponseEntity<?> loginAdmin(LoginDTO loginAdmin);

    public ResponseEntity<?> registerAdmin(Admin admin);

    public ResponseEntity<Boolean> isAdmin(String emailId);

}
