package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.model.CartItem;
import com.TechM_VSM.VehicleServiceManagement.model.Item;

import java.util.List;

public interface CartService {
    List<CartItem> addItemToCart(List<Item> items, int quantity);
}
