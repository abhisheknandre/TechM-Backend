package com.TechM_VSM.VehicleServiceManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ServiceAdvisorDto {
    private int uId;
    private String Name;
    private String email;


}
