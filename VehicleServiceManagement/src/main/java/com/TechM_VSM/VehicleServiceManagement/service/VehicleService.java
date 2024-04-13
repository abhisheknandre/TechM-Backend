package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleService {
    
    ResponseEntity<String> saveVehicle(Vehicle vehicle);


    ResponseEntity<List<Vehicle>> getAllVehical();
}
