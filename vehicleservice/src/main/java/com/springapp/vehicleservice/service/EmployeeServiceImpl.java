package com.springapp.vehicleservice.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springapp.vehicleservice.dto.LoginDTO;
import com.springapp.vehicleservice.dto.ResponseDTO;
import com.springapp.vehicleservice.model.Employee;
import com.springapp.vehicleservice.repository.EmployeeRepository;
import com.springapp.vehicleservice.utilities.EmployeeConstants;
import com.springapp.vehicleservice.utilities.ValidationConstants;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ValidationService validationService;

    @Override
    public ResponseEntity<?> loginEmployee(LoginDTO loginEmployee) {
        Employee employee = employeeRepository.findByEmployeeEmail(loginEmployee.getEmailId());
        if(employee == null)
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(EmployeeConstants.EMP_NOT_AVAILABLE, loginEmployee.getEmailId()));
        if(employee.getPassword().equals(loginEmployee.getPassword()))
            return ResponseEntity.ok()
                .body(new ResponseDTO(EmployeeConstants.EMP_LOGGED_IN, loginEmployee.getEmailId()));
        return ResponseEntity.badRequest()
            .body(new ResponseDTO(EmployeeConstants.INVALID_CREDENTIALS, loginEmployee.getEmailId()));
    }

    @Override
    public ResponseEntity<?> registerEmployee(Employee employee) {
        if(!isValidRequest(employee))
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(ValidationConstants.IS_NOT_VALID, employee.getEmployeeEmail()));
        if(!isAdmin(employee.getEmployerEmail())) {
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(EmployeeConstants.NOT_ADMIN, 
                    Map.of(
                        "Employeer Email", employee.getEmployerEmail(),
                        "Employee Email", employee.getEmployeeEmail()
                    )
                ));
        }
        Employee findEmployee = employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail());
        if(findEmployee != null) {
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(EmployeeConstants.EMP_EXISTS, employee.getEmployeeEmail()));
        }
        Employee employeeInsert = employeeRepository.save(employee);
        return ResponseEntity.ok()
            .body(new ResponseDTO(EmployeeConstants.EMP_ADDED, Map.of(
                "Employeer Email", employeeInsert.getEmployerEmail(),
                "Employee Email", employeeInsert.getEmployeeEmail()
            )
        ));
    }

    @Override
    public ResponseEntity<Boolean> isEmployee(String emailId) {
        Employee findEmployee = employeeRepository.findByEmployeeEmail(emailId);
        if(findEmployee != null) 
            return ResponseEntity.ok().body(Boolean.TRUE);
        return ResponseEntity.ok().body(Boolean.FALSE);
    }

    private boolean isAdmin(String emailId) {
        ResponseEntity<Boolean> isAdmin = adminService.isAdmin(emailId);
        return isAdmin.getBody();
    }

    private boolean isValidRequest(Employee employee) {
        boolean isValid = validationService.isValidRequest(employee.getEmployeeEmail(), employee.getPassword(), employee.getEmployeeName(), employee.getContactNo());
        return isValid;
    }
    
}
