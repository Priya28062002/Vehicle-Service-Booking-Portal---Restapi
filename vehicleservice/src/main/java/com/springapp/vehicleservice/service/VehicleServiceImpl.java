package com.springapp.vehicleservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springapp.vehicleservice.dto.EmailRequestDTO;
import com.springapp.vehicleservice.dto.ResponseDTO;
import com.springapp.vehicleservice.model.VehicleService;
import com.springapp.vehicleservice.repository.ChargesRepository;
import com.springapp.vehicleservice.repository.VehicleServiceRepository;
import com.springapp.vehicleservice.utilities.VehicleServiceConstants;

@Service
public class VehicleServiceImpl implements VehicleServices {

    @Autowired
    private VehicleServiceRepository vehicleServiceRepository;
    
    @Autowired
    private ChargesRepository chargesRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<?> getServiceHistory(int id) {
        Optional<VehicleService> vehicleService = vehicleServiceRepository.findById(id);
        if(vehicleService.isPresent())
            return ResponseEntity.ok()
                .body(new ResponseDTO("Vehicle Service History", vehicleService));
        return ResponseEntity.badRequest()
                    .body(new ResponseDTO(VehicleServiceConstants.SERVICE_NOT_EXISTS, id));
    }

    @Override
    public ResponseEntity<?> addService(VehicleService vehicleService) {
        if(!isUser(vehicleService.getUserEmail())) 
            return ResponseEntity.badRequest()
                .body(new ResponseDTO(VehicleServiceConstants.USER_NOT_EXISTS, vehicleService.getUserEmail()));
        vehicleServiceRepository.save(vehicleService);
        chargesRepository.save(vehicleService.getCharges());
        return ResponseEntity.ok()
                    .body(new ResponseDTO(VehicleServiceConstants.SERVICE_ADDED, vehicleService.getRegistrationNumber()));
    }

    @Override
    public ResponseEntity<?> closeService(int id, EmailRequestDTO emailRequest) {
        if(!isAdmin(emailRequest.getEmailId()))
            return ResponseEntity.badRequest()
                        .body(new ResponseDTO(VehicleServiceConstants.NOT_AUTHORIZED, emailRequest.getEmailId()));
        Optional<VehicleService> vehicleService = vehicleServiceRepository.findByVehicleId(id);
        if(vehicleService.isPresent()) {
            if(vehicleService.get().getStatus().equals("Closed"))
                return ResponseEntity.badRequest()
                            .body(new ResponseDTO(VehicleServiceConstants.SERVICE_NOT_CLOSED, vehicleService.get().getRegistrationNumber()));
            vehicleService.get().setStatus("Closed");
            vehicleServiceRepository.save(vehicleService.get());
            return ResponseEntity.ok()
                        .body(new ResponseDTO(VehicleServiceConstants.SERVICE_CLOSED, vehicleService.get().getRegistrationNumber()));
        }
        return ResponseEntity.badRequest()
                    .body(new ResponseDTO(VehicleServiceConstants.SERVICE_NOT_CLOSED, vehicleService.get().getRegistrationNumber()));
    }

    @Override
    public ResponseEntity<?> checkServiceStatus(int id) {
        Optional<VehicleService> vehicleService = vehicleServiceRepository.findByVehicleId(id);
        if(vehicleService.isPresent()) 
            return ResponseEntity.ok()
                        .body(new ResponseDTO("Status", vehicleService.get().getStatus()));
        return ResponseEntity.badRequest()
                    .body(new ResponseDTO(VehicleServiceConstants.SERVICE_NOT_EXISTS, id));
    }

    @Override
    public ResponseEntity<?> deleteService(int id, EmailRequestDTO emailRequest) {
        if(!isAdmin(emailRequest.getEmailId()))
            return ResponseEntity.badRequest()
                        .body(new ResponseDTO(VehicleServiceConstants.NOT_AUTHORIZED, emailRequest.getEmailId()));
        Optional<VehicleService> vehicleService = vehicleServiceRepository.findByVehicleId(id);
        if(vehicleService.isPresent()) {
            if(vehicleService.get().getStatus().equals("Closed")) {
                vehicleServiceRepository.delete(vehicleService.get());
                return ResponseEntity.ok()
                            .body(new ResponseDTO(VehicleServiceConstants.SERVICE_DELETED, vehicleService.get().getRegistrationNumber()));
            }
            return ResponseEntity.badRequest()
                        .body(new ResponseDTO(VehicleServiceConstants.SERVICE_NOT_CLOSED, vehicleService.get().getRegistrationNumber()));
        }
        return ResponseEntity.badRequest()
                    .body(new ResponseDTO(VehicleServiceConstants.SERVICE_NOT_CLOSED, vehicleService.get().getRegistrationNumber()));
    }

    @Override
    public ResponseEntity<?> fetchOpenServices(int pageNo, int pageSize, EmailRequestDTO emailRequest) {
        if(isAdmin(emailRequest.getEmailId()) || isEmployee(emailRequest.getEmailId())) {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            List<VehicleService> openServices = vehicleServiceRepository.findAllOpenServices(pageable).toList();
            return ResponseEntity.ok()
                    .body(new ResponseDTO("Open Vehicle Services", openServices));
        }
        return ResponseEntity.badRequest()
                        .body(new ResponseDTO(VehicleServiceConstants.NOT_AUTHORIZED, emailRequest.getEmailId()));
    }

    @Override
    public ResponseEntity<?> servicesSortByName(String sortBy, String sortName, EmailRequestDTO emailRequest) {
        if(isAdmin(emailRequest.getEmailId()) || isEmployee(emailRequest.getEmailId())) {
            List<VehicleService> vehicleServices = new ArrayList<>();
            if(sortBy == null)
                sortBy = "ASC";
            if(sortName == null)
                sortName = "vehicleId";
            if(sortBy.equalsIgnoreCase("ASC"))
                vehicleServices = vehicleServiceRepository.findAll(Sort.by(sortName).ascending());
            else
                vehicleServices = vehicleServiceRepository.findAll(Sort.by(sortName).descending());
            return ResponseEntity.ok()
                        .body(new ResponseDTO("Sorted Vehicle Services", vehicleServices));
        }
        return ResponseEntity.badRequest()
                        .body(new ResponseDTO(VehicleServiceConstants.NOT_AUTHORIZED, emailRequest.getEmailId()));
    }

    private boolean isAdmin(String emailId) {
        ResponseEntity<Boolean> isAdmin = adminService.isAdmin(emailId);
        return isAdmin.getBody();
    }
    
    private boolean isEmployee(String emailId) {
        ResponseEntity<Boolean> isEmployee = employeeService.isEmployee(emailId);
        return isEmployee.getBody();
    }

    private boolean isUser(String emailId) {
        ResponseEntity<Boolean> isUser = userService.isUser(emailId);
        return isUser.getBody();
    }
    
}
