package com.project.foodcatalogue.repository;

import com.project.foodcatalogue.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {

    List<FoodItem> findByRestaurantId(int restaurantId);
}
