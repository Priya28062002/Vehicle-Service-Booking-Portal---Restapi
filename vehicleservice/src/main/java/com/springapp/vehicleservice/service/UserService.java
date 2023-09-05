package com.springapp.vehicleservice.service;

import org.springframework.http.ResponseEntity;

import com.springapp.vehicleservice.dto.EmailRequestDTO;
import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.model.User;

public interface UserService {

    public ResponseEntity<?> userLogin(LoginDTO loginUser);

    public ResponseEntity<?> userRegister(User user);

    public ResponseEntity<?> getAllUser(EmailRequestDTO emailRequest);

    public ResponseEntity<Boolean> isUser(String emailId);
    
}
