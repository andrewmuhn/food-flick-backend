package com.cvent.foodflick.mapper;

import com.cvent.foodflick.models.Restaurant;
import com.cvent.foodflick.models.dto.CreateRestaurantDTO;
import com.cvent.foodflick.models.dto.RestaurantDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDTO toDTO(Restaurant restaurant);
    Restaurant toRestaurant(RestaurantDTO dto);
    Restaurant fromCreateRestaurantDTO(CreateRestaurantDTO dto);
}
