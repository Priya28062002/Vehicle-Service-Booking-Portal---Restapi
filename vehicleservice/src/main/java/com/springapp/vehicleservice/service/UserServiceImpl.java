package com.springapp.vehicleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springapp.vehicleservice.dto.EmailRequestDTO;
import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.dto.ResponseDTO;
import com.springapp.vehicleservice.model.User;
import com.springapp.vehicleservice.repository.UserRepository;
import com.springapp.vehicleservice.utilities.UserConstants;
import com.springapp.vehicleservice.utilities.ValidationConstants;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ValidationService validationService;

    @Override
    public ResponseEntity<?> userLogin(LoginDTO loginUser) {
        User user = userRepository.findByUserEmail(loginUser.getEmailId());
        if(user == null)
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(UserConstants.USER_NOT_AVAILABLE, loginUser.getEmailId()));
        if(user.getPassword().equals(loginUser.getPassword()))
            return ResponseEntity.ok()
                .body(new ResponseDTO(UserConstants.USER_LOGGED_IN, loginUser.getEmailId()));
        return ResponseEntity.badRequest()
            .body(new ResponseDTO(UserConstants.INVALID_CREDENTIALS, loginUser.getEmailId()));
    }

    @Override
    public ResponseEntity<?> userRegister(User user) {
        if(!isValidRequest(user))
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(ValidationConstants.IS_NOT_VALID, user.getUserEmail()));
        User findUser = userRepository.findByUserEmail(user.getUserEmail());
        if(findUser != null) 
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(UserConstants.USER_EXISTS, user.getUserEmail()));
        User userInsert = userRepository.save(user);
        return ResponseEntity.ok()
            .body(new ResponseDTO(UserConstants.USER_ADDED, userInsert.getUserEmail()));
    }

    @Override
    public ResponseEntity<Boolean> isUser(String emailId) {
        User findUser = userRepository.findByUserEmail(emailId);
        if(findUser != null)
            return ResponseEntity.ok().body(Boolean.TRUE);
        return ResponseEntity.ok().body(Boolean.FALSE);
    }

    @Override
    public ResponseEntity<?> getAllUser(EmailRequestDTO emailRequest) {
        if(isAdmin(emailRequest.getEmailId()) || isEmployee(emailRequest.getEmailId())) {
            List<User> users = userRepository.findAll();
            return ResponseEntity.ok()
                .body(new ResponseDTO(UserConstants.USER_LIST, users));
        }
        return ResponseEntity.badRequest()
            .body(new ResponseDTO(UserConstants.NOT_AUTHORIZED, emailRequest.getEmailId()));
    }

    private boolean isAdmin(String emailId) {
        ResponseEntity<Boolean> isAdmin = adminService.isAdmin(emailId);
        return isAdmin.getBody();
    }
    
    private boolean isEmployee(String emailId) {
        ResponseEntity<Boolean> isEmployee = employeeService.isEmployee(emailId);
        return isEmployee.getBody();
    }

    private boolean isValidRequest(User user) {
        boolean isValid = validationService.isValidRequest(user.getUserEmail(), user.getPassword(), user.getUserName(), user.getContactNo());
        return isValid;
    }

}
