package com.springapp.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springapp.vehicleservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserEmail(String userEmail);
    
}
