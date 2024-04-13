package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;

import java.util.List;

public interface VehicleService {


    public Vehicle saveVehicle(Vehicle vehicle);

    public List<Vehicle> getAllVehical();
}
