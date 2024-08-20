package com.cvent.foodflick.services.utils;

import com.cvent.foodflick.models.Restaurant;
import com.cvent.foodflick.models.Vote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetermineWinners {
    public DetermineWinners() {
    }

    public List<Long> determineWinners(List<Restaurant> restaurants){

        int highestCount = 0;
        List<Long> highestCountRestaurantIds = new ArrayList<>();

        for (Restaurant restaurant: restaurants){
            int restaurantVoteCount = 0;
            long restaurantId = restaurant.getRestaurant_id();
            List<Vote> votes = restaurant.getVotes();

            for (Vote vote: votes){
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
