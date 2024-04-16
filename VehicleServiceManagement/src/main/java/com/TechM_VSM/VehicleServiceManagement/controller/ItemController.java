package com.TechM_VSM.VehicleServiceManagement.controller;

import com.TechM_VSM.VehicleServiceManagement.dto.ItemDto;
import com.TechM_VSM.VehicleServiceManagement.dto.VehicleDto;
import com.TechM_VSM.VehicleServiceManagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody ItemDto itemDto) {
        ItemDto createdItemDto = itemService.saveVehicle(itemDto);
        if(createdItemDto == null) return new ResponseEntity<>("Vehical not created", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdItemDto, HttpStatus.CREATED);
    }
}
