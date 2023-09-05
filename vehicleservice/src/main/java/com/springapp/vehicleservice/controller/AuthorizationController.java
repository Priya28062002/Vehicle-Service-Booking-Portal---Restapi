package com.springapp.vehicleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.vehicleservice.dto.EmailRequestDTO;
import com.springapp.vehicleservice.service.AuthorizarionService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthorizationController {

    @Autowired
    private AuthorizarionService authorizarionService;

    @GetMapping("/user")
    public ResponseEntity<Boolean> isUser(@RequestBody EmailRequestDTO emailRequest) {
        return authorizarionService.isUser(emailRequest);
    }

    @GetMapping("/admin")
    public ResponseEntity<Boolean> isAdmin(@RequestBody EmailRequestDTO emailRequest) {
        return authorizarionService.isAdmin(emailRequest);
    }

    @GetMapping("/employee")
    public ResponseEntity<Boolean> isEmployee(@RequestBody EmailRequestDTO emailRequest) {
        return authorizarionService.isEmployee(emailRequest);
    }
    
}
