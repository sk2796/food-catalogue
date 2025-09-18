package com.project.foodcatalogue.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String itemName;
    private String itemDescription;
    private boolean isVegetarian;
    private double price;
    private int restaurantId;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int quantity;
}
