package com.springapp.vehicleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.vehicleservice.dto.EmailRequestDTO;
import com.springapp.vehicleservice.model.VehicleService;
import com.springapp.vehicleservice.service.VehicleServices;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "*")
public class VehicleServiceController {

    @Autowired
    private VehicleServices vehicleServices;

    @GetMapping("/getHistory/{id}")
    public ResponseEntity<?> getHistory(@PathVariable("id") int id) {
        return vehicleServices.getServiceHistory(id);
    }

    @PostMapping("/addService")
    public ResponseEntity<?> addService(@RequestBody VehicleService vehicleService) {
        return vehicleServices.addService(vehicleService);
    }

    @PutMapping("/closeService/{id}")
    public ResponseEntity<?> closeService(@PathVariable("id") int id, @RequestBody EmailRequestDTO emailRequest) {
        return vehicleServices.closeService(id, emailRequest);
    }

    @GetMapping("/checkStatus/{id}")
    public ResponseEntity<?> checkServiceStatus(@PathVariable("id") int id) {
        return vehicleServices.checkServiceStatus(id);
    }

    @DeleteMapping("/deleteService/{id}")
    public ResponseEntity<?> deleteServiceById(@PathVariable("id") int id, @RequestBody EmailRequestDTO emailRequest) {
        return vehicleServices.deleteService(id, emailRequest);
    }
    
    @GetMapping("/openServices")
    public ResponseEntity<?> fetchOpenServices(@RequestBody EmailRequestDTO emailRequest, @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return vehicleServices.fetchOpenServices(pageNo, pageSize, emailRequest);
    }
    
    @GetMapping("/fetchAllServices")
    public ResponseEntity<?> fetchAllServices(@RequestBody EmailRequestDTO emailRequest, @RequestParam(required = false) ResponseEntity<?> sortBy, @RequestParam(required = false) ResponseEntity<?> sortName) {
        return vehicleServices.servicesSortByName(null, null, emailRequest);
    }
    
}