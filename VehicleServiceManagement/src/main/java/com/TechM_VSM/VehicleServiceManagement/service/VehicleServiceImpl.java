package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.dto.VehicleDto;
import com.TechM_VSM.VehicleServiceManagement.model.ServiceStatus;
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
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle newvehical = new Vehicle();

        newvehical.setOwnerId(vehicleDto.getOwnerId());
        newvehical.setName(vehicleDto.getName());
        newvehical.setYear(vehicleDto.getYear());
        newvehical.setLicensePlate(vehicleDto.getLicensePlate());
        newvehical.setServiceStatus(vehicleDto.getServiceStatus() != null ? vehicleDto.getServiceStatus() : ServiceStatus.Pending);
        newvehical.setRegistrationDate(new Date());
        Vehicle createdvehicle = vehicleRepository.save(newvehical);
        VehicleDto vehicleDto1 = new VehicleDto();
        vehicleDto1.setId(createdvehicle.getId());
        return vehicleDto1;
    }


    @Override
    public ResponseEntity<List<Vehicle>> getAllVehical() {
        return new ResponseEntity<>(vehicleRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vehicle> getvehicleById(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        return new ResponseEntity<>(vehicle.get(),HttpStatus.OK);
    }

    @Override
    public Vehicle updateVehicle(int id, VehicleDto vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findByid(id);

        vehicle.setOwnerId(vehicleDetails.getOwnerId());
        vehicle.setName(vehicleDetails.getName());
        vehicle.setYear(vehicleDetails.getYear());
        vehicle.setLicensePlate(vehicleDetails.getLicensePlate());

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return updatedVehicle;
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
