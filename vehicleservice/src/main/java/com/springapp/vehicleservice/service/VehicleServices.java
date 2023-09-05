package com.springapp.vehicleservice.service;

import org.springframework.http.ResponseEntity;

import com.springapp.vehicleservice.dto.EmailRequestDTO;
import com.springapp.vehicleservice.model.VehicleService;

public interface VehicleServices {
    
    public ResponseEntity<?> getServiceHistory(int id);

    public ResponseEntity<?> addService(VehicleService vehicleService);

    public ResponseEntity<?> closeService(int id, EmailRequestDTO emailRequest);

    public ResponseEntity<?> checkServiceStatus(int id);

    public ResponseEntity<?> deleteService(int id, EmailRequestDTO emailRequest);

    public ResponseEntity<?> fetchOpenServices(int pageNo, int pageSize, EmailRequestDTO emailRequest);

    public ResponseEntity<?> servicesSortByName(String sortBy, String sortName, EmailRequestDTO emailRequest);

}
