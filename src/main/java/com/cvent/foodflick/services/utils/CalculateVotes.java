package com.cvent.foodflick.services.utils;

import com.cvent.foodflick.models.dto.DinnerPartyDTO;
import com.cvent.foodflick.models.dto.RestaurantDTO;
import com.cvent.foodflick.models.dto.VoteDTO;
import com.cvent.foodflick.services.DinnerPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateVotes {
    private final DinnerPartyService dinnerPartyService;


    @Autowired
    public CalculateVotes(DinnerPartyService dinnerPartyService) {
        this.dinnerPartyService = dinnerPartyService;
    }

    @Transactional
    public List<Long> determineWinners(Long dinnerPartyId){
        DinnerPartyDTO dinnerParty = dinnerPartyService.getDinnerPartyById(dinnerPartyId);
        List<RestaurantDTO> restaurants = dinnerParty.getRestaurants();

        int highestCount = 0;
        List<Long> highestCountRestaurantIds = new ArrayList<>();

        for (RestaurantDTO restaurant: restaurants){
            int restaurantVoteCount = 0;
            long restaurantId = restaurant.getRestaurant_id();
            List<VoteDTO> votes = restaurant.getVotes();

            for (VoteDTO vote: votes){
                if (vote.isVote()){
                    restaurantVoteCount++;
                }
            }

            if (restaurantVoteCount > highestCount) {
                highestCount = restaurantVoteCount;
                highestCountRestaurantIds = new ArrayList<>(List.of(restaurantId));
            } else if (restaurantVoteCount == highestCount) {
                highestCountRestaurantIds.add(restaurantId);
            }

        }
        return highestCountRestaurantIds;
    }

}
