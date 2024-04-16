package com.TechM_VSM.VehicleServiceManagement.dto;
import com.TechM_VSM.VehicleServiceManagement.model.ServiceStatus;
import lombok.Data;

@Data
public class VehicleDto {
    private int id;
    private int ownerId;
    private String name;
    private int year;
    private String licensePlate;
    private ServiceStatus serviceStatus;

}
