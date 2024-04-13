package com.TechM_VSM.VehicleServiceManagement.controller;

import com.TechM_VSM.VehicleServiceManagement.Model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.TechM_VSM.VehicleServiceManagement.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public Vehicle add(@RequestBody Vehicle vehicle){return vehicleService.saveVehicle(vehicle);}

    @GetMapping("/getAll")
    public List<Vehicle> list(){return vehicleService.getAllVehical();}
}
