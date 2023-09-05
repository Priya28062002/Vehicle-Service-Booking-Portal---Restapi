package com.springapp.vehicleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.dto.ResponseDTO;
import com.springapp.vehicleservice.model.Admin;
import com.springapp.vehicleservice.repository.AdminRepository;
import com.springapp.vehicleservice.utilities.AdminConstants;
import com.springapp.vehicleservice.utilities.ValidationConstants;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    public ResponseEntity<?> loginAdmin(LoginDTO loginAdmin) {
        Admin admin = adminRepository.findByAdminEmail(loginAdmin.getEmailId());
        if(admin == null)
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(AdminConstants.ADMIN_NOT_AVAILABLE, loginAdmin.getEmailId()));
        if(admin.getPassword().equals(loginAdmin.getPassword()))
            return ResponseEntity.ok()
                .body(new ResponseDTO(AdminConstants.ADMIN_LOGGED_IN, loginAdmin.getEmailId()));
        return ResponseEntity.badRequest()
            .body(new ResponseDTO(AdminConstants.INVALID_CREDENTIALS, loginAdmin.getEmailId()));
    }

    @Override
    public ResponseEntity<?> registerAdmin(Admin admin) {
        if(!isValidRequest(admin))
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(ValidationConstants.IS_NOT_VALID, admin.getAdminEmail()));
        Admin findAdmin = adminRepository.findByAdminEmail(admin.getAdminEmail());
        if(findAdmin != null)
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(AdminConstants.ADMIN_EXISTS, admin.getAdminEmail()));
        Admin adminInsert = adminRepository.save(admin);
        return ResponseEntity.ok()
            .body(new ResponseDTO(AdminConstants.ADMIN_ADDED, adminInsert.getAdminEmail()));
    }

    @Override
    public ResponseEntity<Boolean> isAdmin(String emailId) {
        Admin findAdmin = adminRepository.findByAdminEmail(emailId);
        if(findAdmin != null)
            return ResponseEntity.ok().body(Boolean.TRUE);
        return ResponseEntity.ok().body(Boolean.FALSE);
    }

    private boolean isValidRequest(Admin admin) {
        boolean isValid = validationService.isValidRequest(admin.getAdminEmail(), admin.getPassword(), admin.getAdminName(), admin.getContactNo());
        return isValid;
    }
    
}
