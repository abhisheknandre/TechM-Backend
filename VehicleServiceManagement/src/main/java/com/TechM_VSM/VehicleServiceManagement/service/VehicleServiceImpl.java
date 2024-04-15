package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.TechM_VSM.VehicleServiceManagement.repository.VehicleRepository;

import java.util.*;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public ResponseEntity<String> saveVehicle(Vehicle vehicle) {
             vehicleRepository.save(vehicle);
             return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Vehicle>> getAllVehical() {
        return new ResponseEntity<>(vehicleRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vehicle> getQuestionById(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        return new ResponseEntity<>(vehicle.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vehicle> updateVehicle(int id, Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findByid(id);

        vehicle.setC_id(vehicleDetails.getC_id());
        vehicle.setName(vehicleDetails.getName());
        vehicle.setYear(vehicleDetails.getYear());
        vehicle.setLicense_plate(vehicleDetails.getLicense_plate());

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    @Override
    public Map<String, Boolean> deleteVehicle(int id) {
        Vehicle vehicle = vehicleRepository.findByid(id);
        vehicleRepository.delete(vehicle);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
