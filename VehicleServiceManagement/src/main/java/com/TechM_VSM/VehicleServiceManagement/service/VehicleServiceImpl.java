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

        newvehical.setOwnerName(vehicleDto.getOwnerName());
        newvehical.setName(vehicleDto.getName());
        newvehical.setYear(vehicleDto.getYear());
        newvehical.setLicensePlate(vehicleDto.getLicensePlate());
        newvehical.setServiceStatus(vehicleDto.getServiceStatus() != null ? vehicleDto.getServiceStatus() : ServiceStatus.Pending);
        newvehical.setOEmail(vehicleDto.getOEmail());
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
    public Vehicle updateStatus(int id, VehicleDto vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findByid(id);

        vehicle.setSaEmail(vehicleDetails.getSaEmail());
        vehicle.setServiceStatus(vehicleDetails.getServiceStatus());
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

    @Override
    public List<Vehicle> getVehiclesByServiceStatus(String serviceStatus) {
        ServiceStatus serviceStatusEnum = ServiceStatus.valueOf(serviceStatus); // Convert String to enum
        List<Vehicle> vehicles = vehicleRepository.findByServiceStatus(serviceStatusEnum);
        return vehicles;
    }

    @Override
    public List<Vehicle> getByAdvisorAndStatus(String advisorEmail, String serviceStatus) {
        return vehicleRepository.getVehicleListFromAdvisorAndServiceStatus(advisorEmail, serviceStatus);
    }

    @Override
    public Vehicle updateVehicle(int id, VehicleDto vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findByid(id);

        vehicle.setName(vehicleDetails.getName());
        vehicle.setOwnerName(vehicleDetails.getOwnerName());
        vehicle.setOEmail(vehicleDetails.getOEmail());
        vehicle.setLicensePlate(vehicleDetails.getLicensePlate());
        vehicle.setYear(vehicleDetails.getYear());
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return updatedVehicle;

    }


}
