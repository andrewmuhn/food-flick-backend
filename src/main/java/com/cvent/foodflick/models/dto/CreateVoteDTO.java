package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotNull;

public class CreateVoteDTO {
    @NotNull
    private boolean vote;

    private long restaurant_id;

    public CreateVoteDTO() {
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
