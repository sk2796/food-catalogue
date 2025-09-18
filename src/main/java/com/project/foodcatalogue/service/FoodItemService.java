package com.project.foodcatalogue.service;

import com.project.foodcatalogue.dto.FoodCataloguePage;
import com.project.foodcatalogue.dto.FoodItemDto;
import com.project.foodcatalogue.dto.Restaurant;
import com.project.foodcatalogue.mapper.FoodItemMapper;
import com.project.foodcatalogue.model.FoodItem;
import com.project.foodcatalogue.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItem) {
        FoodItem saved = foodItemRepository.save(FoodItemMapper.INSTANCE.toFoodItem(foodItem));
        return FoodItemMapper.INSTANCE.toFoodItemDto(saved);
    }

    public List<FoodItemDto> getAllFoodItems() {
        return foodItemRepository.findAll()
                .stream()
                .map(FoodItemMapper.INSTANCE::toFoodItemDto)
                .collect(Collectors.toList());
    }

    public FoodItemDto getFoodItemById(int id) {
        return foodItemRepository.findById(id)
                .map(FoodItemMapper.INSTANCE::toFoodItemDto)
                .orElse(null);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(int restaurantId) {

        List<FoodItemDto> foodItems = fetchFoodItemList(restaurantId);

        Restaurant restaurant = fetchRestaurantDetails(restaurantId);
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setRestaurant(restaurant);
        foodCataloguePage.setFoodItemList(foodItems);

        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetails(int restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/" + restaurantId, Restaurant.class);
    }

    private List<FoodItemDto> fetchFoodItemList(int restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(FoodItemMapper.INSTANCE::toFoodItemDto)
                .toList();
    }
}
