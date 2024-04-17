package com.TechM_VSM.VehicleServiceManagement.controller;

import com.TechM_VSM.VehicleServiceManagement.dto.ItemDto;
import com.TechM_VSM.VehicleServiceManagement.dto.VehicleDto;
import com.TechM_VSM.VehicleServiceManagement.model.Item;
import com.TechM_VSM.VehicleServiceManagement.model.Vehicle;
import com.TechM_VSM.VehicleServiceManagement.repository.ItemRepository;
import com.TechM_VSM.VehicleServiceManagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody ItemDto itemDto) {
        ItemDto createdItemDto = itemService.saveVehicle(itemDto);
        if(createdItemDto == null) return new ResponseEntity<>("Vehical not created", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdItemDto, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getItem()
    {
        return itemService.getAll();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Item> getById(@PathVariable int id){
        return itemService.getitemById(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVehicle(@PathVariable int id) {
        Map<String, Boolean> response = itemService.deleteItem(id);
        return ResponseEntity.ok(response);
    }


}
