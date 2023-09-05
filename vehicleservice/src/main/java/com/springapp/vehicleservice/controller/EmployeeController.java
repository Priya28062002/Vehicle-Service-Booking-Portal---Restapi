package com.springapp.vehicleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.model.Employee;
import com.springapp.vehicleservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
	private EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<?> employeeLogin(@RequestBody LoginDTO loginEmployee) {
        return employeeService.loginEmployee(loginEmployee);
    }   

    @PostMapping("/register")
    public ResponseEntity<?> employeeRegister(@RequestBody Employee employee) {
        return employeeService.registerEmployee(employee);
    }
    
}
