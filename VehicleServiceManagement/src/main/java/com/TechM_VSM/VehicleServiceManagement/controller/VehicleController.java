package com.TechM_VSM.VehicleServiceManagement.controller;

import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.TechM_VSM.VehicleServiceManagement.service.VehicleService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @PostMapping("/add")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return vehicleService.getAllVehical();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable int id){
        return vehicleService.getQuestionById(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable int id,@RequestBody Vehicle vehicleDetails){
        return vehicleService.updateVehicle(id, vehicleDetails);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVehicle(@PathVariable int id) {
        Map<String, Boolean> response = vehicleService.deleteVehicle(id);
        return ResponseEntity.ok(response);
    }


}
