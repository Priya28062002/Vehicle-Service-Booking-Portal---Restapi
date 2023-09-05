package com.springapp.vehicleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.vehicleservice.dto.EmailRequestDTO;
import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.model.User;
import com.springapp.vehicleservice.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDTO loginUser) {
        return userService.userLogin(loginUser);
    }

    @PostMapping("/register")
	public ResponseEntity<?> userRegister(@RequestBody User user) {
        return userService.userRegister(user);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllUsers(@RequestBody EmailRequestDTO emailRequest) {
        return userService.getAllUser(emailRequest);
    }
    
}
