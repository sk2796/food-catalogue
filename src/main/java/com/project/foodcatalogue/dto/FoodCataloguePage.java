package com.project.foodcatalogue.dto;

import com.project.foodcatalogue.model.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    private List<FoodItemDto> foodItemList;
    private Restaurant restaurant;
}
