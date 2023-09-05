package com.springapp.vehicleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springapp.vehicleservice.dto.EmailRequestDTO;

@Service
public class AuthorizationServiceImpl implements AuthorizarionService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<Boolean> isUser(EmailRequestDTO emailRequest) {
        return userService.isUser(emailRequest.getEmailId());
    }

    @Override
    public ResponseEntity<Boolean> isAdmin(EmailRequestDTO emailRequest) {
        return adminService.isAdmin(emailRequest.getEmailId());
    }

    @Override
    public ResponseEntity<Boolean> isEmployee(EmailRequestDTO emailRequest) {
        return employeeService.isEmployee(emailRequest.getEmailId());
    }
    
}
