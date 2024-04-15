package com.TechM_VSM.VehicleServiceManagement.controller;

import com.TechM_VSM.VehicleServiceManagement.dto.SignupRequest;
import com.TechM_VSM.VehicleServiceManagement.dto.UserDto;
import com.TechM_VSM.VehicleServiceManagement.model.User;
import com.TechM_VSM.VehicleServiceManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> add(@RequestBody SignupRequest signupRequest) {
        if (userService.hasUserwithEmail(signupRequest.getEmail())) {
            return new ResponseEntity<>("Customer already exists with this email!", HttpStatus.CONFLICT);
        }

        UserDto createdUserDto = userService.saveUser(signupRequest);
        if (createdUserDto == null) {
            return new ResponseEntity<>("Customer not created", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String getUser()
    {
        System.out.println("Getting user");
        return "Welcome";
    }

}
