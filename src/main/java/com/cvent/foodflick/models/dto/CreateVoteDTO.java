package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotNull;

public class CreateVoteDTO {
    @NotNull
    private boolean vote;

    private long restaurant_id;

    public CreateVoteDTO() {
    }

    public CreateVoteDTO(boolean vote, long restaurant_id) {
        this.vote = vote;
        this.restaurant_id = restaurant_id;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
