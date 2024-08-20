package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.Vote;
import com.cvent.foodflick.models.YelpMetaData;

import java.util.List;

public class RestaurantDTO {
    private Long restaurant_id;

    private Long dinner_party_id;

    private boolean winner;

    private List<VoteDTO> votes;

    private YelpMetaData yelpMetaData;

    public RestaurantDTO() {
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public Long getDinner_party_id() {
        return dinner_party_id;
    }

    public void setDinner_party_id(Long dinner_party_id) {
        this.dinner_party_id = dinner_party_id;
    }

    public YelpMetaData getYelpMetaData() {
        return yelpMetaData;
    }

    public void setYelpMetaData(YelpMetaData yelpMetaData) {
        this.yelpMetaData = yelpMetaData;
    }

    public List<VoteDTO> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDTO> votes) {
        this.votes = votes;
    }
}
