package com.project.foodcatalogue.controller;

import com.project.foodcatalogue.dto.FoodCataloguePage;
import com.project.foodcatalogue.dto.FoodItemDto;
import com.project.foodcatalogue.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class FoodCatalogueController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItem) {
        return ResponseEntity.ok(foodItemService.addFoodItem(foodItem));
    }

    @GetMapping
    public ResponseEntity<List<FoodItemDto>> getAllFoodItems() {
        return ResponseEntity.ok(foodItemService.getAllFoodItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItemDto> getFoodItemById(@PathVariable int id) {
        FoodItemDto dto = foodItemService.getFoodItemById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getRestaurantAndFoodItemById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> getRestaurantAndFoodItemById(@PathVariable int restaurantId) {
        FoodCataloguePage foodCataloguePage = foodItemService.fetchFoodCataloguePageDetails(restaurantId);
        return ResponseEntity.ok(foodCataloguePage);
    }
}
