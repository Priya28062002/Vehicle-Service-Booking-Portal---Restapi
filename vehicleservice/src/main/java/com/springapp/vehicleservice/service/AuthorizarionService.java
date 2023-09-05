package com.springapp.vehicleservice.service;

import org.springframework.http.ResponseEntity;

import com.springapp.vehicleservice.dto.EmailRequestDTO;

public interface AuthorizarionService {
    
    public ResponseEntity<Boolean> isUser(EmailRequestDTO emailRequest);

    public ResponseEntity<Boolean> isAdmin(EmailRequestDTO emailRequest);

    public ResponseEntity<Boolean> isEmployee(EmailRequestDTO emailRequest);

}
