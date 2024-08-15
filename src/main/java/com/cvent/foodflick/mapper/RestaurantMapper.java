package com.cvent.foodflick.mapper;

import com.cvent.foodflick.models.Restaurant;
import com.cvent.foodflick.models.dto.CreateRestaurantDTO;
import com.cvent.foodflick.models.dto.RestaurantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    @Mapping(source="dinnerParty.dinner_party_id", target = "dinner_party_id")
    RestaurantDTO toRestaurantDTO(Restaurant restaurant);
    Restaurant toRestaurant(RestaurantDTO dto);
    Restaurant fromCreateRestaurantDTO(CreateRestaurantDTO dto);
}
