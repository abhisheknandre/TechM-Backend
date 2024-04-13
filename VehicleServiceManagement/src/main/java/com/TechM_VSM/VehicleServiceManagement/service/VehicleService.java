package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface VehicleService {
    
    public ResponseEntity<String> saveVehicle(Vehicle vehicle);


    public ResponseEntity<List<Vehicle>> getAllVehical();

    public ResponseEntity<Vehicle> getQuestionById(int id);


    public ResponseEntity<Vehicle> updateVehicle(int id, Vehicle vehicleDetails);

    public Map<String, Boolean> deleteVehicle(int id);
}
