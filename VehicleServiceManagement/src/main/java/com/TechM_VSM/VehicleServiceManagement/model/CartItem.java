package com.TechM_VSM.VehicleServiceManagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Item item;
    private int quantity;
    private int vId;
    public CartItem(Item item, int quantity) {
    }
}
