package com.TechM_VSM.VehicleServiceManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ownerId;
    private String name;
    private int year;
    private String licensePlate;
    private ServiceStatus serviceStatus;
    private Date registrationDate;
}
