package com.TechM_VSM.VehicleServiceManagement.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int v_id;
    private int c_id;
    private String name;
    private int year;
    private String license_plate;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdDate;

    public Vehicle() {
        createdDate = new Timestamp(System.currentTimeMillis());
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getCreatedDate() {
        return createdDate.toString();
    }
}
