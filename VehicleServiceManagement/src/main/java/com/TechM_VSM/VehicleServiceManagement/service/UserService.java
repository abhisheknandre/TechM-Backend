package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.dto.ServiceAdvisorDto;
import com.TechM_VSM.VehicleServiceManagement.dto.SignupRequest;
import com.TechM_VSM.VehicleServiceManagement.dto.UserDto;
import com.TechM_VSM.VehicleServiceManagement.model.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public UserDto saveUser(SignupRequest signupRequest);

    public boolean hasUserwithEmail(String email);


    List<User> findAllUsers();


}
