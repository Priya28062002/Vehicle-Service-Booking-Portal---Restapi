package com.springapp.vehicleservice.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.springapp.vehicleservice.utilities.ValidationConstants;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean isValidRequest(String emailId, String password, String name, String contactNo) {
        boolean isValid = isValidEmail(emailId) && isValidContactNo(contactNo) &&
                            isValidName(name) && isValidPassword(password);
        return isValid;
    }

    private boolean isValidEmail(String emailId) {
        Pattern emailPattern = Pattern.compile(ValidationConstants.EMAIL_REGEX);
        Matcher emailMatcher = emailPattern.matcher(emailId);
        boolean isValid = emailMatcher.matches();
        return isValid;
    }

    private boolean isValidContactNo(String contactNo) {
        Pattern phonePattern = Pattern.compile(ValidationConstants.PHONE_REGEX);
        Matcher phoneMatcher = phonePattern.matcher(contactNo);
        boolean isValid = phoneMatcher.matches();
        return isValid;
    }

    private boolean isValidName(String name) {
        Pattern namePattern = Pattern.compile(ValidationConstants.NAME_REGEX);
        Matcher nameMatcher = namePattern.matcher(name);
        boolean isValid = nameMatcher.matches();
        return isValid;
    }

    private boolean isValidPassword(String password) {
        Pattern passwordPattern = Pattern.compile(ValidationConstants.PASSWORD_REGEX);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        boolean isValid = passwordMatcher.matches();
        return isValid;
    }
    
}
