package com.TechM_VSM.VehicleServiceManagement.controller;

import com.TechM_VSM.VehicleServiceManagement.dto.VehicleDto;
import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;
import com.TechM_VSM.VehicleServiceManagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advisor")
@CrossOrigin
public class AdvisorController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getByAdvisorAndStatus")
    public ResponseEntity<List<Vehicle>> getByAdvisorAndStatus(
            @RequestParam("advisor_email") String advisorEmail,
            @RequestParam("service_status") String serviceStatus) {

        List<Vehicle> resultList = vehicleService.getByAdvisorAndStatus(advisorEmail, serviceStatus);

        if (resultList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(resultList);
    }

}
