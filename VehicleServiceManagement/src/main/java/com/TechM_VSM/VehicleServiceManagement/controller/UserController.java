package com.TechM_VSM.VehicleServiceManagement.controller;

import com.TechM_VSM.VehicleServiceManagement.Model.User;
import com.TechM_VSM.VehicleServiceManagement.Model.Vehicle;
import com.TechM_VSM.VehicleServiceManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User add(@RequestBody User user){return userService.saveVehicle(user);}

}
