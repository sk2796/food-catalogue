package com.project.foodcatalogue.mapper;

import com.project.foodcatalogue.dto.FoodItemDto;
import com.project.foodcatalogue.model.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDto toFoodItemDto(FoodItem foodItem);

    FoodItem toFoodItem(FoodItemDto foodItemDto);
}
