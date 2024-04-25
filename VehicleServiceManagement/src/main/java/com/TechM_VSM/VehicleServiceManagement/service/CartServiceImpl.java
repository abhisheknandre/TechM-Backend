package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.model.CartItem;
import com.TechM_VSM.VehicleServiceManagement.model.Item;
import com.TechM_VSM.VehicleServiceManagement.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CartItem> addItemToCart(List<Item> items, int quantity) {
        List<CartItem> cartItems = new ArrayList<>();
        for (Item item : items) {
            CartItem cartItem = new CartItem(item, quantity);

            cartItem = cartRepository.save(cartItem);

            cartItems.add(cartItem);
        }
        return cartItems;
    }
}
