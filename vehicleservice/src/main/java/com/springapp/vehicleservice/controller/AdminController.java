package com.springapp.vehicleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.model.Admin;
import com.springapp.vehicleservice.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@RequestBody LoginDTO loginAdmin) {
        return adminService.loginAdmin(loginAdmin);
    }

    @PostMapping("/register")
    public ResponseEntity<?> adminRegister(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }
    
}
