package com.cvent.foodflick.services;

import com.cvent.foodflick.exceptions.ResourceNotFoundException;
import com.cvent.foodflick.mapper.RestaurantMapper;
import com.cvent.foodflick.models.DinnerParty;
import com.cvent.foodflick.models.Restaurant;
import com.cvent.foodflick.models.dto.CreateRestaurantDTO;
import com.cvent.foodflick.models.dto.DinnerPartyDTO;
import com.cvent.foodflick.models.dto.RestaurantDTO;
import com.cvent.foodflick.repositories.DinnerPartyRepository;
import com.cvent.foodflick.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final DinnerPartyRepository dinnerPartyRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper, DinnerPartyRepository dinnerPartyRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
        this.dinnerPartyRepository = dinnerPartyRepository;
    }

    public RestaurantDTO createRestaurantForDinnerParty(Long dinnerPartyId, CreateRestaurantDTO createRestaurantDTO) {
        DinnerParty dinnerParty = dinnerPartyRepository.findById(dinnerPartyId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Dinner Party with id: %d not found", dinnerPartyId)));

        Restaurant restaurant = restaurantMapper.fromCreateRestaurantDTO(createRestaurantDTO);
        restaurant.setDinnerParty(dinnerParty);

        Restaurant createdRestaurant = restaurantRepository.save(restaurant);

        return restaurantMapper.toRestaurantDTO(createdRestaurant);
    }

    public RestaurantDTO updateWinnerForRestaurant(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id: %d not found"+ restaurantId));
        restaurant.setWinner(true);
        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);

        return restaurantMapper.toRestaurantDTO(updatedRestaurant);

    }

}
