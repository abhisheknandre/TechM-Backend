package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.dto.VehicleDto;
import com.TechM_VSM.VehicleServiceManagement.model.ServiceStatus;
import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.TechM_VSM.VehicleServiceManagement.repository.VehicleRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@EnableScheduling
public class VehicleServiceImpl implements VehicleService {
    private static final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Scheduled(cron = "0 0 0 * * *") // This will run once a day at 11:35 PM
    @Transactional
    public void updateStatus() {
        logger.info("Starting updateStatus at {}", LocalDateTime.now());

        LocalDate twoMonthsAgo = LocalDate.now().minusMonths(2);
        vehicleRepository.updateStatusAndDate(twoMonthsAgo);

        logger.info("Completed updateStatus at {}", LocalDateTime.now());
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle newVehicle = new Vehicle();

        newVehicle.setOwnerName(vehicleDto.getOwnerName());
        newVehicle.setName(vehicleDto.getName());
        newVehicle.setYear(vehicleDto.getYear());
        newVehicle.setLicensePlate(vehicleDto.getLicensePlate());
        newVehicle.setServiceStatus(vehicleDto.getServiceStatus() != null ? vehicleDto.getServiceStatus() : ServiceStatus.Pending);
        newVehicle.setOEmail(vehicleDto.getOEmail());
        newVehicle.setRegistrationDate(new Date());
        newVehicle.setServiceDonedate(null);
        Vehicle createdVehicle = vehicleRepository.save(newVehicle);
        VehicleDto vehicleDto1 = new VehicleDto();
        return vehicleDto1;
    }

    @Override
    public ResponseEntity<List<Vehicle>> getAllVehical() {
        return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vehicle> getvehicleById(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return new ResponseEntity<>(vehicle.get(), HttpStatus.OK);
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

    @Override
    public Vehicle updateStatus1(int id, VehicleDto vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findByid(id);

        vehicle.setServiceStatus(vehicleDetails.getServiceStatus());
        System.out.println("h1llllwkd");
        System.out.println();
        String status = String.valueOf(vehicleDetails.getServiceStatus());
        System.out.println("Service Status: " + status);
        if (status.equals("Completed")) {
            System.out.println("Service Status Inside If: " + status);
            System.out.println(LocalDate.now());
            vehicle.setServiceDonedate(LocalDate.now());
        }

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return updatedVehicle;
    }

    @Override
    public List<Vehicle> getByAdvisorAndStatus(String getemail) {
        List<Vehicle> resultList = vehicleRepository.findBySaEmail(getemail);
        return resultList;
    }
}
