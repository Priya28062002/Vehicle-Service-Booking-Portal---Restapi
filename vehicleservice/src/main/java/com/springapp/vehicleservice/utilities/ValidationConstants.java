package com.springapp.vehicleservice.utilities;

public interface ValidationConstants {

    String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    String PHONE_REGEX = "(0/91)?[7-9][0-9]{9}";

    String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";

    String NAME_REGEX = "^[A-Za-z]+( [A-Za-z]+)*$";

    String IS_NOT_VALID = "Please Give the Valid Details";
    
}
