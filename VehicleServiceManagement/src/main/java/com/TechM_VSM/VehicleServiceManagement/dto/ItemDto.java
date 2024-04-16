package com.TechM_VSM.VehicleServiceManagement.dto;

import lombok.Data;

@Data
public class ItemDto {
    private int itemId;
    private  String itemName;
    private  String itemDescription;
    private  double itemCost;
}
