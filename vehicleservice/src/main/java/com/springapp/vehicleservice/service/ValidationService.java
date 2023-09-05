package com.springapp.vehicleservice.service;

public interface ValidationService {

    public boolean isValidRequest(String emailId, String password, String name, String contactNo);
    
}
